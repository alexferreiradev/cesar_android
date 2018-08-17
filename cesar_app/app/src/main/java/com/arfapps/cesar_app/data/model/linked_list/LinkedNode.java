package com.arfapps.cesar_app.data.model.linked_list;

public class LinkedNode<ValueType> {
	private LinkedNode<ValueType> next;
	private ValueType value;

	public LinkedNode<ValueType> getNext() {
		return next;
	}

	public void setNext(LinkedNode<ValueType> next) {
		this.next = next;
	}

	public ValueType getValue() {
		return value;
	}

	public void setValue(ValueType value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LinkedNode)) return false;

		LinkedNode<?> that = (LinkedNode<?>) o;

		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		int result = next != null ? next.hashCode() : 0;
		result = 31 * result + value.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "LinkedNode{" +
				" value=" + value +
				", next=" + next +
				'}';
	}
}
