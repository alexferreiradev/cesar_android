package com.arfapps.cesar_app.ui.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.arfapps.cesar_app.R;
import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.repository.ItemRepository;
import com.arfapps.cesar_app.ui.view.contract.MainContract;

import java.util.List;

public class MainPresenter extends BaseListPresenter<MainContract.View, Email, ItemRepository, String, Number, List<Email>> implements MainContract.Presenter {

	private static final String LOAD_EMAIL = "load_email_task";
	private static final String LOAD_EMAIL_BY_TITULO = "load_email_by_titulo";
	private static final int PARAM_TASK_TYPE = 0;
	private static final int PARAM_TASK_QUERY = 1;

	public MainPresenter(MainContract.View mView, Context mContext, Bundle savedInstanceState, ItemRepository mRepository) {
		super(mView, mContext, savedInstanceState, mRepository);
	}

	@Override
	protected List<Email> loadInBackground(String[] strings) {
		String taskType = strings[PARAM_TASK_TYPE];

		switch (taskType) {
			case LOAD_EMAIL:
				return mRepository.getAllEmails();
			case LOAD_EMAIL_BY_TITULO:
				String query = strings[PARAM_TASK_QUERY];
				return mRepository.getAllEmailsByTitulo(query);
		}

		return null;
	}

	@Override
	protected void backgroundFinished(@NonNull List<Email> emails) {
		mView.createListAdapter(emails);
	}

	@Override
	protected void setEmptyView() {
		mView.setEmptyView(mContext.getString(R.string.item_not_loaded));
	}

	@Override
	protected void loadDataFromSource() {
		BackgroundTask task = new BackgroundTask();
		task.execute(LOAD_EMAIL);
	}

	@Override
	public void selectItemClicked(Email item, int pos) {

	}

	@Override
	public void searchBy(String query) {
		BackgroundTask task = new BackgroundTask();
		task.execute(LOAD_EMAIL_BY_TITULO, query);
	}
}
