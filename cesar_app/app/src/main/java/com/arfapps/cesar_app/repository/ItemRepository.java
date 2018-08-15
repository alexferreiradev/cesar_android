package com.arfapps.cesar_app.repository;

import com.arfapps.cesar_app.data.model.ItemList;

import java.util.List;

public class ItemRepository implements DefaultRepository<ItemList> {

	@Override
	public void setCacheToDirty() {

	}

	@Override
	public boolean hasCache() {
		return false;
	}

	@Override
	public List<ItemList> getCurrentCache() {
		return null;
	}

	@Override
	public ItemList create(ItemList model) {
		return null;
	}

	@Override
	public ItemList recover(Long id) {
		return null;
	}

	@Override
	public ItemList update(ItemList model) {
		return null;
	}

	@Override
	public ItemList delete(ItemList model) {
		return null;
	}
}
