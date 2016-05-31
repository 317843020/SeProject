package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.question;
import Util.MyDataSource;

/*
 * �������й��� ���Խ����޸ĸ��º�ɾ��
 * */
public class manage_question {
	
	MyDataSource mysource=null;
	PreparedStatement stmt = null;
	
	public manage_question()
	{
		 mysource=new MyDataSource();
	}
       
	public boolean update(question que,String type) throws SQLException
	{
		
		String sql=null;
		if(type.equals("select"))
		{
			
			sql="update squestion set tespar_id=? , que_des=? , answer=? ,choice=? "+
			"where question_id=?";
		}
			
		else if(type.equals("judge"))
		{
			sql="update jquesion set tespar_id=? , que_des=? , answer=? "+
		    "where question_id=?";
			
		}
		else return false;
		
		Connection con=mysource.getConnection();		
		stmt=con.prepareStatement(sql);
		stmt.setString(1, que.getTespar_id());
		stmt.setString(2,que.getQue_des());
		stmt.setString(3, que.getAnswer());
		if(type.equals("select"))
		{
			stmt.setString(4, que.getChoice());
			stmt.setString(5, que.getQuesion_id());
		}
		else if(type.equals("judge"))
		{
			stmt.setString(4, que.getQuesion_id());
		}
		if(stmt.executeUpdate()==1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean delete(question que,String type) throws SQLException
	{
		
		String sql=null;
		if(type.equals("select"))
		{
			
			sql="delete squestion where question_id=?";
			
		}			
		else if(type.equals("judge"))
		{
			sql="delete jquesion where question_id=?";
			
		}		
		else return false;
		
		Connection con=mysource.getConnection();		
		stmt=con.prepareStatement(sql);
		if(stmt.executeUpdate()==1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
