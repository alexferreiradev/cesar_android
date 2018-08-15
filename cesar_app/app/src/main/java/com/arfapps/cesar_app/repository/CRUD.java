package com.arfapps.cesar_app.repository;

import com.arfapps.cesar_app.data.model.BaseModel;

public interface CRUD<ModelType extends BaseModel> {

	ModelType create(ModelType model);

	ModelType recover(Long id);

	ModelType update(ModelType model);

	ModelType delete(ModelType model);

}
