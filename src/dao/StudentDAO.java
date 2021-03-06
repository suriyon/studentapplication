package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Student;
import util.MySQLHelper;

public class StudentDAO {
	public boolean insert(Student student){
		boolean result = false;
		String sql = "insert into student(studentId, studentName, branchId) values(?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, student.getStudentId());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getBranchId());
			
			int row = ps.executeUpdate();
			if(row>0){
				result = true;
			}else{
				result = false;
			}
			MySQLHelper.closeDB();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean update(Student student){
		boolean result = false;
		String sql = "update student set studentName = ? where studentId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(2, student.getStudentId());
			ps.setString(1, student.getStudentName());			
			
			int row = ps.executeUpdate();
			if(row>0){
				result = true;
			}else{
				result = false;
			}
			MySQLHelper.closeDB();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<Student> selectStudentAll(){
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getString(1));
				student.setStudentName(rs.getString(2));
				student.setBranchId(rs.getString(3));
				
				students.add(student);
			}
			MySQLHelper.closeDB();
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public Vector showStudentAll(){
		Vector students = new Vector<>();
		Vector student;
		String sql = "select * from student";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				student = new Vector<>();
				for (int i=1;i<=column;i++) {
					student.add(rs.getString(i));
				}
				students.add(student);
			}
			MySQLHelper.closeDB();
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	public Vector selectStudentByName(String studentName){
		Vector students = new Vector<>();
		Vector student;
		String sql = "select * from student where studentName like ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, "%" + studentName + "%");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				student = new Vector<>();
				for (int i=1;i<=column;i++) {
					student.add(rs.getString(i));
				}
				students.add(student);
			}
			MySQLHelper.closeDB();
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
