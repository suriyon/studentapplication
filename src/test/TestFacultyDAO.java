package test;

import java.util.List;

import javax.swing.JOptionPane;

import dao.FacultyDAO;
import model.Faculty;

public class TestFacultyDAO {
	public static void main(String[] args) {
		FacultyDAO dao = new FacultyDAO();
//		����������
//		Faculty faculty = new Faculty();
//		faculty.setFacultyId("00006");
//		faculty.setFacultyName("�Է�ҡ�ä���������");		
//		boolean result = dao.insert(faculty);
//		if(result){
//			JOptionPane.showMessageDialog(null, "����������㹵��ҧ������������");
//		}else{
//			JOptionPane.showMessageDialog(null, "����������㹵��ҧ�����������");
//		}
		
//		�ʴ�������
//		System.out.println("Before Update");
//		List<Faculty> facultys = dao.selectAll();
//		for (Faculty faculty : facultys) {
//			System.out.println(faculty.toString());
//		}
		
//		��䢢�����
//		Faculty faculty = new Faculty();
//		faculty.setFacultyId("00005");
//		faculty.setFacultyName("�ɵ���ʵ��");
//		
//		boolean result = dao.update(faculty);
//		if(result){
//			JOptionPane.showMessageDialog(null, "��䢢�����㹵��ҧ������������");			
//		}else{
//			JOptionPane.showMessageDialog(null, "��䢢�����㹵��ҧ�����������");
//		}
//		
		
//		ź������
//		boolean result = dao.delete("00001");
//		if(result){
//			JOptionPane.showMessageDialog(null, "ź������㹵��ҧ������������");			
//		}else{
//			JOptionPane.showMessageDialog(null, "ź������㹵��ҧ�����������");
//		}
		
		System.out.println(dao.genFacId());
	}
}
