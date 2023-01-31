package application;

public class main {

	public static void main(String[] args) {
		Student m1= new Student(1300,"sc",77);
		Student m2= new Student(1200,"sc",77);
		Student m3= new Student(1400,"sc",80);
		Student m4= new Student(1800,"sc",80);
		Student m5= new Student(1600,"sc",100);
		Student m6= new Student(1700,"sc",100);
		Student m7= new Student(1100,"sc",77);

		Join<Student> j= new Join<>();
		j.insert(m1);
		j.insert(m2);j.insert(m3);j.insert(m4);j.insert(m5);j.insert(m6);
		j.insert(m7);
		System.out.println("Doubly LINked List");
		j.doublyList.traverse();
		
		System.out.println("MARKS AVL");
		j.LLAVL.traverseInOrder();
		
		System.out.println("Seats AVL");
		j.SeatsLists.traverseInOrderWithPointer();;
		
		System.out.println(j.SeatsLists.root.right.left.pointer);
		
		System.out.println(j.findBySeatNumber(1400));
		//m1.mark=1000;
		System.out.println("MARKS AVL");
		j.LLAVL.traverseInOrder();
		
//		System.out.println("Seats AVL");
//		j.SeatsLists.traverseInOrderWithPointer();;
		
		//j.LLAVL.deletePucket(m1);
//		j.LLAVL.deletePucket(m2);
//		Student m8= new Student(1200,"sc",90);
//		j.LLAVL.insert(m8);
		//j.LLAVL.deletePucket(m3);
		j.update2(1200, "sssss", 101);

		System.out.println("Marks after delet");
		j.LLAVL.traverseInOrder();
//		j.SeatsLists.traverseLevel();
		j.findBySeatNumber(1100);
		
	}

}
