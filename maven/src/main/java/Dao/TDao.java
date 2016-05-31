package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.Tpaper;
import Util.JdbcUtils;

public class TDao {
	public Tpaper findpaperByid(String id) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Tpaper tpaper = null;
		try {
			String sql = "select * from tpaper where paper_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				tpaper = new Tpaper();
				tpaper.setId(rs.getString("paper_id"));
				tpaper.setStarttime(rs.getString("start_time"));
				tpaper.setEndtime(rs.getString("end_time"));
				tpaper.setKemu(rs.getString("comment"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		return tpaper;

	}
	
	public Tpaper findpaperBykemu(String kemu) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Tpaper tpaper = null;
		try {
			String sql = "select * from tpaper where comment = ? and now()  between start_time and end_time";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, kemu);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				//System.out.println("okokkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
				tpaper = new Tpaper();
				tpaper.setId(rs.getString("paper_id"));
				tpaper.setStarttime(rs.getString("start_time"));
				tpaper.setEndtime(rs.getString("end_time"));
				tpaper.setKemu(rs.getString("comment"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		return tpaper;

	}
	
	
	public List findAllkemu() {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<String> tpaperkemu =new ArrayList<String>();;
		try {
			String sql = "select distinct  comment from tpaper ";
			stmt = conn.prepareStatement(sql);
		
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				//System.out.println(rs.getRow()+rs.getString(1));
				
				tpaperkemu.add((String)rs.getString(1));
			}
	//		System.out.println(tpaperkemu.get(0)+tpaperkemu.get(1));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		return tpaperkemu;

	}
	
}
