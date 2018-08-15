package com.arfapps.cesar_app.repository;

import com.arfapps.cesar_app.data.model.BaseModel;

import java.util.List;

public interface DefaultRepository<ModelType extends BaseModel> extends CRUD<ModelType> {

	void setCacheToDirty();

	boolean hasCache();

	List<ModelType> getCurrentCache();

}
