package com.arfapps.cesar_app.data.model;

import java.io.Serializable;

/**
 * Created by Alex on 16/03/2017.
 */

public abstract class BaseModel<ModelType> implements Serializable {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();

	@Override
	public abstract String toString();
}
