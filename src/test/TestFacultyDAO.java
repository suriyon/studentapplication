package test;

import java.util.List;

import javax.swing.JOptionPane;

import dao.FacultyDAO;
import model.Faculty;

public class TestFacultyDAO {
	public static void main(String[] args) {
		FacultyDAO dao = new FacultyDAO();
//		เพิ่มข้อมูล
//		Faculty faculty = new Faculty();
//		faculty.setFacultyId("00006");
//		faculty.setFacultyName("วิทยาการคอมพิวเตอร์");		
//		boolean result = dao.insert(faculty);
//		if(result){
//			JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลในตารางคณะสำเร็จแล้ว");
//		}else{
//			JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลในตารางคณะไม่สำเร็จ");
//		}
		
//		แสดงข้อมูล
//		System.out.println("Before Update");
//		List<Faculty> facultys = dao.selectAll();
//		for (Faculty faculty : facultys) {
//			System.out.println(faculty.toString());
//		}
		
//		แก้ไขข้อมูล
//		Faculty faculty = new Faculty();
//		faculty.setFacultyId("00005");
//		faculty.setFacultyName("เกษตรศาสตร์");
//		
//		boolean result = dao.update(faculty);
//		if(result){
//			JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลในตารางคณะสำเร็จแล้ว");			
//		}else{
//			JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลในตารางคณะไม่สำเร็จ");
//		}
//		
		
//		ลบข้อมูล
//		boolean result = dao.delete("00001");
//		if(result){
//			JOptionPane.showMessageDialog(null, "ลบข้อมูลในตารางคณะสำเร็จแล้ว");			
//		}else{
//			JOptionPane.showMessageDialog(null, "ลบข้อมูลในตารางคณะไม่สำเร็จ");
//		}
		
		System.out.println(dao.genFacId());
	}
}
