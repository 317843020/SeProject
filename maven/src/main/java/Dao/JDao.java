package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.Jquestion;
import Util.JdbcUtils;

public class JDao {
	public List<Jquestion> findquestion(String paperid) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Jquestion> jquestionlist  =new ArrayList<Jquestion>();
		try {
			String sql = "select * from jquestion where tespar_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,paperid);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				//System.out.println("fffffffffffffffffffffffffff");
				Jquestion jquestion = new Jquestion();  
				jquestion.setAnswer(rs.getString("answer"));
				jquestion.setId(rs.getString("question_id"));
				jquestion.setPaperid(rs.getString("tespar_id"));
				jquestion.setQue_des(rs.getString("que_des"));
				jquestionlist.add(jquestion);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		return jquestionlist;

	}

}
