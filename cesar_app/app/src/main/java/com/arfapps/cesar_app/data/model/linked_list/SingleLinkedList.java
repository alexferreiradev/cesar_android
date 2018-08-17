package com.arfapps.cesar_app.data.model.linked_list;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class SingleLinkedList<ValueType> implements LinkedList<ValueType>, Serializable {

	private LinkedNode<ValueType> head;
	private Long size;

	@Override
	public LinkedNode<ValueType> getHead() {
		return head;
	}

	@Override
	public Long getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == null || size == 0;
	}

	@Override
	public LinkedNode<ValueType> addLast(ValueType value) {
		if (isEmpty()) {
			return createByHead(value);
		}

		LinkedNode<ValueType> node = createNode(value);
		LinkedNode<ValueType> nodeAux = head;
		for (int i = 0; i < size; i++) {
			if (nodeAux.getNext() == null) {
				nodeAux.setNext(node);
				break;
			} else {
				nodeAux = nodeAux.getNext();
			}
		}

		return node;
	}

	private LinkedNode<ValueType> createByHead(ValueType value) {
		LinkedNode<ValueType> node = createNode(value);
		head = node;
		size = 1L;

		return node;
	}

	@NonNull
	private LinkedNode<ValueType> createNode(ValueType value) {
		LinkedNode<ValueType> node = new LinkedNode<>();
		node.setValue(value);
		node.setNext(null);
		return node;
	}

	@Override
	public LinkedNode<ValueType> remove(ValueType value) {
		return null;
	}
}
