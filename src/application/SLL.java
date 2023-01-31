package application;

public class SLL<T extends Comparable<T>> {
	SLLNode<T> head;

	public SLL() {
	}
	
	public void insertAtHead(T data) {
		SLLNode<T> newNode= new SLLNode<T>(data);
		if(head == null) {
			head=newNode;
		}else {
			newNode.next=head;
			head=newNode;
		}
	}
	
	public SLLNode<T> delete(T data) {
		if(head == null) {
			return null;
		}else {
			SLLNode<T>prev=null;
			SLLNode<T>curr=head;
			while(curr!=null && !curr.data.equals(data)) {
				prev=curr;
				curr=curr.next;
			}
			if(curr==null)
				return null;
			if(curr.data.equals(data)) {
				SLLNode<T> temp= curr;
				if(prev == null) {
					head=curr.next;
				}else {
				prev.next=curr.next;
				}
				return temp;
			}else {
				return null;
			}
		}
	}
	public void traverse() {
		if(head!=null) {
			System.out.print("head");
			SLLNode<T> curr=head;
			while(curr!=null) {
				System.out.print(" --> "+ curr.data);
				curr=curr.next;
			}
			System.out.println(" --> null");
		}else {
			System.out.println("Empty");
		}
	}
	

	@Override
	public String toString() {
		String s="";
		if(head!=null) {
			s+="H";
			SLLNode<T> curr=head;
			while(curr!=null) {
				s+=" --> "+ curr.data;
				curr=curr.next;
			}
			s+=" --> N";
		}else {
			s+="Empty"+"\n";
		}
		return s;
	}

	public static void main(String[] args) {
		SLL<Integer> mySLL= new SLL<Integer>();
		mySLL.insertAtHead(5);
		mySLL.insertAtHead(4);
		mySLL.insertAtHead(3);
		mySLL.insertAtHead(2);
		mySLL.insertAtHead(1);
		mySLL.traverse();
		mySLL.delete(1);
		mySLL.delete(10);
		mySLL.traverse();;
	}

}
