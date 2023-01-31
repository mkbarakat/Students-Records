package application;

public class DLL<T extends Comparable<T>> {
	DLLNode<T> head;

	public DLL() {
	}

	public DLLNode<T> getHead() {
		return head;
	}

	public void setHead(DLLNode<T> head) {
		this.head = head;
	}
	public void insertAtHead(T data) {
		DLLNode<T> newNode= new DLLNode<T>(data);
		if (head == null) {
			head=newNode;
			head.next=head;
			head.prev=head;
		}else {
			newNode.next=head;
			newNode.prev=head.prev;
			head.prev.next=newNode;
			head.prev=newNode;
			head=newNode;
		}
	}
	
	public T delete(T data) {
		if(head!=null) {
			if(head.next==head) {// if we have just one node
				if(head.data.equals(data)) {// if the only node equals the data we want to delete
				DLLNode<T> temp=head;
				head=null;
				return temp.data;
				}else {return null;}// if the only node doesn't equal the data we want to delete
			}if(head.next!=head && head.data.equals(data)) {// if there more than one node and we want to delete the first node, we need to update the head
				DLLNode<T> curr=head;
				curr.prev.next=curr.next;
				curr.next.prev=curr.prev;
				head=head.next;
				return curr.data;
				
			}else {//                  if we have more than one node
				DLLNode<T> curr= head;
				while(true) {         // search for the data in the list
					curr=curr.next;
					if(curr==head) { // if we back to the first point then we don't find the data
						return null;
					}
					if(curr.data.equals(data)) {// if the data in the middle or at last
						DLLNode<T> temp=curr;
						curr.prev.next=curr.next;
						curr.next.prev=curr.prev;
						return temp.data;
					}
				}
			}
		}else {// if head equal null then its empty
			return null;
		}
		
	}
	
	public String traverse() {
		String s="\n";
		if (head != null) {
			
			System.out.println();
			s+="head";
			System.out.print("head");
			DLLNode<T> curr= head;
			while(true) {
				s+=" <=> " + curr.data;
				System.out.print(" <=> " + curr.data);
				curr=curr.next;
				if (curr==head) {
					break;
				}
			}
			s+=" --> head";
			System.out.println(" --> head");
		}
		else {
			s+="Empty";
			System.out.println("Empty");
		}return s;
	}
	public void traverseBack() {
		if (head != null) {
			System.out.println();
			System.out.print("head");
			DLLNode<T> curr= head.prev;
			while(true) {
				System.out.print(" --> " + curr.data);
				curr=curr.prev;
				if (curr==head.prev) {
					break;
				}
			}
			System.out.println(" --> head");
		}
		else {
			System.out.println("Empty");
		}
	}
	
	
	public static void main(String[] args) {
		DLL<Integer> myDLL= new DLL<Integer>();
		myDLL.insertAtHead(5);
		myDLL.insertAtHead(4);
		myDLL.insertAtHead(3);
		myDLL.insertAtHead(2);
		myDLL.insertAtHead(1);
		myDLL.insertAtHead(0);
		myDLL.traverse();
		myDLL.traverseBack();
		System.out.println(myDLL.head);
		System.out.println(myDLL.delete(5));
		System.out.println(myDLL.delete(0));
		System.out.println(myDLL.delete(3));
		myDLL.traverse();
		myDLL.traverseBack();
	}
}
