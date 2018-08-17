package com.arfapps.cesar_app.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class EmailBroadcastReceiver extends BroadcastReceiver {

	@SuppressWarnings("ConstantConditions")
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.hasExtra(CleanerEmailService.Constants.EXTENDED_DATA_STATUS)) {
			String emailThreadId = intent.getExtras().getString(CleanerEmailService.Constants.EXTENDED_DATA_STATUS);
			// envia uma notification to the user about the limpeza da thread de emails dele.
		}
	}

}
