package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.p_user;
import Util.MyDataSource;
/*
 * ����Աֻ��ɾ���û������޸��û���Ϣ
 * */
public class manage_student {
	
	MyDataSource mysource=null;
	PreparedStatement stmt = null;
	
	public manage_student()
	{
		 mysource=new MyDataSource();
	}
      
	  boolean delete_sd(p_user user) throws SQLException
	  {
		 
			Connection con=mysource.getConnection();		
			String sql="delete from student where id=? ";
			
			stmt=con.prepareStatement(sql);
			stmt.setString(1, user.getId());

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
