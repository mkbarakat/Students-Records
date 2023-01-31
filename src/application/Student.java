package application;


public class Student implements Comparable<Student>{
	 int id;
	 String branch;
	 double mark;

	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String branch, double mark) {
		super();
		this.id = id;
		this.branch = branch;
		this.mark = mark;
	}
	
	
	public int getId() {
		return id;
	}
	public String getBranch() {
		return branch;
	}
	public double getMark() {
		return mark;
	}
	
	@Override
	public String toString() {
		return "SN: " + id + "," + branch + ", M: " + mark + ".";
	}
	@Override
	public int compareTo(Student s2) {
		if (this.getMark()>s2.getMark()) {
			return 1;
		}else if(this.getMark()<s2.getMark()) {
			return -1;
		}
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id;
	}
	
//	public int compareTo(Student s2) {
//		if (this.getId()>s2.getId()) {
//			return 1;
//		}else if(this.getId()<s2.getId()) {
//			return -1;
//		}
//		return 0;
//	}
	
	
}
