package model;

public class Student {
	private String studentId;
	private String studentName;
//	private String branchId;
	private Branch branch;
	public Student() {
		super();
	}
	public Student(String studentId, String studentName, Branch branch) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.branch = branch;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
