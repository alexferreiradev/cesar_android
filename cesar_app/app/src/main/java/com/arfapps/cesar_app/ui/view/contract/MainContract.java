package com.arfapps.cesar_app.ui.view.contract;

import com.arfapps.cesar_app.data.model.ItemList;

public interface MainContract {

	interface Presenter extends BaseListContract.Presenter<ItemList> {
		// Ignorado
	}

	interface View extends BaseListContract.View<ItemList> {
		// Ignorado
	}
}
