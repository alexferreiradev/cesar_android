package com.arfapps.cesar_app.service;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.data.model.linked_list.SingleLinkedList;
import com.arfapps.cesar_app.repository.ItemRepository;
import com.arfapps.cesar_app.util.EmailUtils;

public final class CleanerEmailService extends JobIntentService {

	private static final String TAG = CleanerEmailService.class.getSimpleName();

	private ItemRepository itemRepository;

	@Override
	public void onCreate() {
		super.onCreate();
		itemRepository = new ItemRepository();
	}

	@SuppressWarnings({"unchecked", "ConstantConditions"})
	@Override
	protected void onHandleWork(@NonNull Intent intent) {
		if (intent.hasExtra(Constants.SERVICE_PARAM_KEY)) {
			String emailThreadId = intent.getExtras().getString(Constants.SERVICE_PARAM_KEY);
			if (emailThreadId != null) {
				Log.i(TAG, "Iniciando servico para email thread: " + emailThreadId);
				SingleLinkedList<Email> emailList = itemRepository.getLinkedEmailThreadById(emailThreadId);
				Log.i(TAG, "Iniciando remocao de duplicados. " + emailThreadId);
				emailList = EmailUtils.cleanDuplicatedEmails(emailList);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					Log.e(TAG, "Erro ao esperar servico", e);
				}

				Log.i(TAG, "Lista sem duplicados criada. " + emailThreadId);
				itemRepository.saveEmailThread(emailList, emailThreadId);
				Log.i(TAG, "Lista sem duplicados salva. " + emailThreadId);

				Log.i(TAG, "Avisando user. " + emailThreadId);
				Intent localIntent = new Intent(Constants.BROADCAST_ACTION).putExtra(Constants.EXTENDED_DATA_STATUS, emailThreadId);
				LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
			}
		}
	}

	@SuppressWarnings("WeakerAccess")
	public final class Constants {
		public static final String SERVICE_PARAM_KEY = "service_param_key";
		public static final String BROADCAST_ACTION = "com.arfapps.cesar_app.service.EmailBroadcastReceiver";
		public static final String EXTENDED_DATA_STATUS = "com.arfapps.cesar_app.service.STATUS";
	}
}
