package application;

public class DLLNode<T extends Comparable<T>> {
	T data;
	DLLNode<T> next;
	DLLNode<T> prev;
	
	public DLLNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DLLNode<T> getNext() {
		return next;
	}

	public void setNext(DLLNode<T> next) {
		this.next = next;
	}

	public DLLNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DLLNode<T> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "<=>" + data + "<=>";
	}
	
	

}
