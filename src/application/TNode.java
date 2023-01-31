package application;

public class TNode<T extends Comparable<T>> {
	TNode<T> left;
	TNode<T> right;
	DLLNode<Student> pointer;
	T data;
	SLL<T> SLData =new SLL<T>() ;
	
	
	public TNode(T data) {
		SLData.insertAtHead(data);
		this.data=data;
	}


	public DLLNode<Student> getPointer() {
		return pointer;
	}

	public void setPointer(DLLNode<Student> pointer) {
		this.pointer = pointer;
	}



	public T getData() {
		return data;
	}

	public TNode<T> getLeft() {
		return left;
	}

	public void setLeft(TNode<T> left) {
		this.left = left;
	}

	public TNode<T> getRight() {
		return right;
	}

	public void setRight(TNode<T> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public String toString() {
		if(pointer==null)
			return "" + SLData.toString() + "";
		else
			return "--" + pointer + "--";
			
	}
}