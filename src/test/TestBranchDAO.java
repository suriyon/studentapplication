package test;

import javax.swing.JOptionPane;

import dao.BranchDAO;
import model.Branch;

public class TestBranchDAO {
	public static void main(String[] args) {
		BranchDAO dao = new BranchDAO();
		Branch branch = new Branch();
		branch.setBranchId("00008");
		branch.setBrachName("การจัดการเทคโนโลยีสารสนเทศ");
		branch.setFacultyId("00006");
		
		boolean result = dao.insert(branch);
		if(result){
			JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลในตารางสาขาสำเร็จ");
		}else{
			JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลในตารางสาขาไม่สำเร็จ");
		}
	}
}
