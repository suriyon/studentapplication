package model;

public class Branch {
	private String branchId;
	private String brachName;
	//private String facultyId;
	private Faculty faculty;
	public Branch() {
		super();
	}
	public Branch(String branchId, String brachName, Faculty faculty) {
		super();
		this.branchId = branchId;
		this.brachName = brachName;
		this.faculty = faculty;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBrachName() {
		return brachName;
	}
	public void setBrachName(String brachName) {
		this.brachName = brachName;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
}
