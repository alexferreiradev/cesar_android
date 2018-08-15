package com.arfapps.cesar_app.ui.view.contract;

import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.arfapps.cesar_app.data.model.BaseModel;
import com.arfapps.cesar_app.ui.presenter.BasePresenter;
import com.arfapps.cesar_app.ui.presenter.IPresenter;

import java.util.List;

/**
 * Created by Alex on 18/03/2017.
 */

public interface BaseListContract {

	interface View<ModelType extends BaseModel>
			extends BasePresenter.View, AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

		void createListAdapter(List<ModelType> results);

		void addAdapterData(List<ModelType> result);

		void removeAdapterData(List<ModelType> result);

		ListAdapter getAdapter();

		RecyclerView.Adapter getRecycleAdapter();

		void destroyListAdapter();

		void showAddOrEditDataView(ModelType data);

		void showDataView(ModelType data);

		void setEmptyView(String text);

		void setGridScroolPosition(int position);

		int getFirstVisibleItemPosition();

	}

	interface Presenter<ModelType extends BaseModel> extends IPresenter {

		void loadMoreData(int firstVisibleItem, int visibleItemCount, int adapterTotalItems);

		void applyFilter(String filterKey, String filterValue);

		void selectItemClicked(ModelType item, int pos);

	}
}
