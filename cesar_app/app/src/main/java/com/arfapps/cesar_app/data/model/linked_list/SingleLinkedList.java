package com.arfapps.cesar_app.data.model.linked_list;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class SingleLinkedList<ValueType> implements LinkedList<ValueType>, Serializable {

	private LinkedNode<ValueType> head;
	private Long size;

	public SingleLinkedList() {
		this.size = 0L;
	}

	@Override
	public LinkedNode<ValueType> getHead() {
		return head;
	}

	@Override
	public Long getSize() {
		return size;
	}

	@Override
	public void updateSize() {
		size = 0L;

		LinkedNode<ValueType> auxNode = this.head;
		for (; auxNode != null; auxNode = auxNode.getNext()) {
			size++;
		}
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
		LinkedNode<ValueType> auxNode = head;
		for (; auxNode != null; auxNode = auxNode.getNext()) {
			if (auxNode.getNext() == null) {
				auxNode.setNext(node);
				size++;
				break;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("head[");


		LinkedNode<ValueType> auxNode = this.head;
		builder.append(size).append("] -> ");
		for (; auxNode != null; auxNode = auxNode.getNext()) {
			ValueType value = auxNode.getValue();
			builder.append("[").append(value.toString()).append("] -> ");
		}
		builder.append("end");

		return builder.toString();
	}
}
