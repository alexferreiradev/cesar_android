package com.arfapps.cesar_app.ui.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arfapps.cesar_app.R;
import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.repository.ItemRepository;
import com.arfapps.cesar_app.ui.adapter.MainAdapter;
import com.arfapps.cesar_app.ui.presenter.MainPresenter;
import com.arfapps.cesar_app.ui.view.contract.MainContract;

import java.util.List;

public class MainActivity extends BaseActivity<Email, MainContract.View, MainContract.Presenter> implements MainContract.View {

	@BindView(R.id.rvMsg)
	RecyclerView emailRV;
	@BindView(R.id.tvEmpty)
	TextView emptyTV;

	private MainAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ItemRepository repo = new ItemRepository();
		mPresenter = new MainPresenter(this, this, savedInstanceState, repo);
	}

	@Override
	public void initializeWidgets(Bundle savedInstanceState) {
		super.initializeWidgets(savedInstanceState);
		ButterKnife.bind(this);

		emailRV.setLayoutManager(new LinearLayoutManager(this));
	}

	@Override
	public void initializeArgumentsFromIntent() {
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search_item_button).getActionView();
		assert searchManager != null;
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		searchView.setIconified(true);
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {
				mPresenter.searchBy(query);
				return false;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				return false;
			}
		});

		return true;
	}

	@Override
	public void createListAdapter(List<Email> results) {
		adapter = new MainAdapter(results, emptyTV, this);
		emailRV.setAdapter(adapter);
	}

	@Override
	public void addAdapterData(List<Email> result) {

	}

	@Override
	public void removeAdapterData(List<Email> result) {

	}

	@Override
	public ListAdapter getAdapter() {
		return null;
	}

	@Override
	public RecyclerView.Adapter getRecycleAdapter() {
		return adapter;
	}

	@Override
	public void destroyListAdapter() {
		adapter = null;
		emailRV.setAdapter(null);
	}

	@Override
	public void showAddOrEditDataView(Email data) {

	}

	@Override
	public void showDataView(Email data) {

	}

	@Override
	public void setEmptyView(String text) {
		emptyTV.setText(text);
	}

	@Override
	public void setGridScroolPosition(int position) {

	}

	@Override
	public int getFirstVisibleItemPosition() {
		return 0;
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}
}
