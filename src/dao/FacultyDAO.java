package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Faculty;
import util.MySQLHelper;

public class FacultyDAO {
	public boolean delete(String facultyId){
		String sql = "delete from faculty where facultyId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);			
			ps.setString(1, facultyId);
			
			int row = ps.executeUpdate();
			MySQLHelper.closeDB();
			if(row>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	public boolean update(Faculty faculty){
		String sql = "update faculty set facultyName = ? where facultyId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, faculty.getFacultyName());
			ps.setString(2, faculty.getFacultyId());
			
			int row = ps.executeUpdate();
			MySQLHelper.closeDB();
			if(row>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean insert(Faculty faculty){
		String sql = "insert into faculty(facultyId, facultyName) values(?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, faculty.getFacultyId());
			ps.setString(2, faculty.getFacultyName());
			
			int row = ps.executeUpdate();
			MySQLHelper.closeDB();
			if(row>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	public List<Faculty> selectAll(){
		List<Faculty> facultys = new ArrayList<Faculty>();
		String sql = "select * from faculty";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Faculty faculty = new Faculty();
				faculty.setFacultyId(rs.getString(1));
				faculty.setFacultyName(rs.getString(2));
				
				facultys.add(faculty);
			}
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facultys;
	}
	public String genFacId(){
		String sid = null;
		String sql = "select facultyId from faculty order by facultyId desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sid = rs.getString(1);
				MySQLHelper.closeDB();
				int tmp = Integer.parseInt(sid);
				tmp++;
				if(tmp<10){
					sid = "0000" + tmp;
				}else if(tmp<100){
					sid = "000" + tmp;
				}else if(tmp<1000){
					sid = "00" + tmp;
				}else if(tmp<10000){
					sid = "0" + tmp;
				}else{
					sid = "" + tmp;
				}
				return sid;
			}else{
				return "00001";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sid;		
	}
	
	public Vector showFaculty(){
		Vector faculties = new Vector<>();
		Vector faculty;
		String sql = "select * from faculty";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				faculty = new Vector<>();
				for(int i=1;i<=column;i++){
					faculty.add(rs.getString(i));				
				}
				faculties.add(faculty);
			}
			MySQLHelper.closeDB();
			return faculties;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return faculties;
	}
}
