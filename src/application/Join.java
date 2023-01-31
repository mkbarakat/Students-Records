package application;

public class Join<T extends Comparable<T>> {
	AVL<Student> LLAVL=new AVL<>();
	DLL<Student> doublyList = new DLL<>();
	AVL<Integer> SeatsLists = new AVL<>();
	
	public void insert(Student data) {
		doublyList.insertAtHead(data);		
		SeatsLists.insertt(data.getId());
		SeatsLists.lastAdded.setPointer(doublyList.head);
		//System.out.println(SeatsLists.lastAdded);
		LLAVL.insert(data);
	}
	
	public DLLNode<Student> findBySeatNumber(int seatNumber){
		if(SeatsLists.search(seatNumber).data!=null) {
			return SeatsLists.search(seatNumber).pointer;
		}
		return null;
	}
	public boolean isExist(int seatNumber){
		if(SeatsLists.find(seatNumber)!=null) {
			return true;
		}else
		return false;
	}
	
	public Student deletefromAll(int sn) {
		if(isExist(sn)) {
		Student temp = findBySeatNumber(sn).data;
		SeatsLists.delete(sn);
		doublyList.delete(temp);
		LLAVL.deletePucket(temp);
		return temp;
		}else {
		return null;
		}
		
	}
	
	public void update(int seat, String branch, double mark) {
		Student myStudent= findBySeatNumber(seat).data;
		LLAVL.deletePucket(myStudent);
		myStudent.branch=branch;
		myStudent.mark=mark;
		LLAVL.insert(myStudent);
	}
	public void update2(int seat, String branch, double mark) {
		Student myStudent= findBySeatNumber(seat).data;
		deletefromAll(seat);
		myStudent.branch=branch;
		myStudent.mark=mark;
		insert(myStudent);
	}
	
	
	
	public String traverseLevel() {
		String s="";
		int h = height(SeatsLists.root);
		int i;
		for (i = 0; i < h; i++) {
			s+=printLevel(SeatsLists.root, i, 0);
			s+="\n";
			System.out.println(printLevel(SeatsLists.root, i, 0));
			System.out.println();
		}
		return s;
	}
	private int height(TNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private String printLevel(TNode<Integer> root, int i, int j) {

		if (root != null) {
			if (i == j)
				return root.pointer + " ";
			if (j > i)
				return "N";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "N";

	}
	
	public String show() {
		String all="";
		String b= doublyList.traverse();
		String s=SeatsLists.traverseLevel();
		String a=LLAVL.traverseLevel();
		all +="Doubly List"+b+"\n\n";
		all+="seats AVL\n" + s+"\n";
		all+="Marks AVL  \n" + a;
		return all;
	}
	public String getHeight() {
		String all="";
		
		all+= "Mark Tree = "+ LLAVL.height() +"                "+ "Seat Number Tree = "+SeatsLists.height();
		return all;
		
	}
	
}
