package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
