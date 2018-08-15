package com.arfapps.cesar_app.ui.presenter;

import android.content.Context;
import android.os.Bundle;
import com.arfapps.cesar_app.data.model.ItemList;
import com.arfapps.cesar_app.repository.ItemRepository;
import com.arfapps.cesar_app.ui.view.contract.MainContract;

import java.util.List;

public class MainPresenter extends BaseListPresenter<MainContract.View, ItemList, ItemRepository, String, Number, List<ItemList>> implements MainContract.Presenter {

	MainPresenter(MainContract.View mView, Context mContext, Bundle savedInstanceState, ItemRepository mRepository) {
		super(mView, mContext, savedInstanceState, mRepository);
	}

	@Override
	protected void setEmptyView() {

	}

	@Override
	protected void loadDataFromSource() {

	}

	@Override
	public void selectItemClicked(ItemList item, int pos) {

	}
}
