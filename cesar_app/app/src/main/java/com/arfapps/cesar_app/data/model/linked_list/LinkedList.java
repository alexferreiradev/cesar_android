package com.arfapps.cesar_app.data.model.linked_list;

interface LinkedList<ValueType> {

	LinkedNode<ValueType> getHead();

	Long getSize();

	void updateSize();

	boolean isEmpty();

	LinkedNode<ValueType> addLast(ValueType value);

	LinkedNode<ValueType> remove(ValueType value);

	String toString();
}
