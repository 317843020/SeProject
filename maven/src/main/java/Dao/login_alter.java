package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.p_user;
import Util.MyDataSource;

public class login_alter {
	MyDataSource mysource=null;
	PreparedStatement stmt = null;
	
    public login_alter(){
    	 mysource=new MyDataSource();
    }
    //��¼����ģ��
    //�ṩ�û���� �˺� ����
	public boolean login(p_user user) throws SQLException
	{
		String sql;
		if(user.getType().equals("admin"))
			sql="select * from admin where id=? and password=? ";
		else if(user.getType().equals("student"))
			sql="select * from student where id=? and password=? ";
		else return false;
		
		Connection con=mysource.getConnection();		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getId());
		stmt.setString(2, user.getPassword());
		if(stmt.execute()==true)
		{
			System.out.println("lllllllll");
			return true;
		}
		else 
		{
			System.out.println("ooooooooooo");
			return false;
		}
	}
	//ͨ���û� ��� �˺� ԭ�����޸�����
	public boolean alter_pw(p_user user,String new_pw) throws SQLException
	{
			System.out.println(user.getType());
			System.out.println(user.getId());
			System.out.println(user.getPassword());
			System.out.println(new_pw);
		
		String sql;
		if(user.getType().equals("admin"))
			sql="update admin set password=? where id=? and password=? ";
		else if(user.getType().equals("student"))
			sql="update student set password=? where id=? and password=? ";
		else return false;
		
		Connection con=mysource.getConnection();		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, new_pw);
		stmt.setString(2, user.getId());
		stmt.setString(3, user.getPassword());
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
