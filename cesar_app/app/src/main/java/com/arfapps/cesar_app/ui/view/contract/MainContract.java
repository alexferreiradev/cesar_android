package com.arfapps.cesar_app.ui.view.contract;

import com.arfapps.cesar_app.data.model.Email;

public interface MainContract {

	interface Presenter extends BaseListContract.Presenter<Email> {
		void searchBy(String query);

		void cleanDuplicatedList();
		// Ignorado
	}

	interface View extends BaseListContract.View<Email> {
		// Ignorado
	}
}
