package application;

public class SLLNode<T extends Comparable<T>> {
	T data;
	SLLNode<T> next;
	
	public SLLNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SLLNode<T> getNext() {
		return next;
	}

	public void setNext(SLLNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "SLLNode [data=" + data + "]";
	}

	
	
	
}
