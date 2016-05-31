package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.Grade;
import Util.JdbcUtils;

public class GradeDao {

	public List<Grade> findGradebyStudentid(String studentid) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// ArrayList a1=new ArrayList();
		List<Grade> gradelist = new ArrayList<Grade>();

		try {
			String sql = "select * from grade where student_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, studentid);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Grade studentgrade = new Grade();
				studentgrade.setStudent_id(rs.getString("student_id"));
				studentgrade.setPaper_id(rs.getString("paper_id"));
				studentgrade.setGrade(rs.getString("grade"));
				studentgrade.setObject(rs.getString("object"));
				gradelist.add(studentgrade);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}

		return gradelist;
	}

	public boolean Add(Grade grade) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT INTO grade (student_id, paper_id, grade, object)" + " VALUES(?,?,?,?)";
			System.out.println(sql);
			int count = -1;
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, grade.getStudent_id());
			stmt.setString(2, grade.getPaper_id());
			stmt.setString(3, grade.getGrade());
			stmt.setString(4, grade.getObject());
			count = stmt.executeUpdate();

			if (count >= 0) {
				return true;
			} else
				return false;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}

}
