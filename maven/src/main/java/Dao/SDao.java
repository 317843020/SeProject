package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

import Entity.Squestion;
import Util.JdbcUtils;

public class SDao {
	public List<Squestion> findquestion(String paperid) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Squestion> squestionlist  =new ArrayList<Squestion>();
		try {
			String sql = "select * from squestion where tespar_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,paperid);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
			//	System.out.println("fffffffffffffffffffffffffff");
				Squestion squestion = new Squestion();  
				squestion.setAnswer(rs.getString("answer"));
				squestion.setChoice(rs.getString("choice"));
				squestion.setId(rs.getString("question_id"));
				squestion.setPaperid(rs.getString("tespar_id"));
				squestion.setQue_des(rs.getString("que_des"));
				squestionlist.add(squestion);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		return squestionlist;

	}
	
}
