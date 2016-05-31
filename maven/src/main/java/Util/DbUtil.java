package Util;

/**
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.p_user;
import Entity.question;


/**
 * @author Hongten
 * @created 2014-5-18
 */
public class DbUtil {
	
	static MyDataSource mysource=null;
	static PreparedStatement ps = null;
	
	public DbUtil(){
		mysource=new MyDataSource();
	}

    /**
     * @param sql
     */
    public  boolean insert_student(String sql, p_user user) throws SQLException {
    	JdbcUtils jdbcutil=new JdbcUtils();
    	Connection conn=jdbcutil.getConnection();
    	//Connection conn=mysource.getConnection();	
        
        try {
            /*Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);*/
        	System.out.println("sql语句:"+sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSex());           
            System.out.println("进入insert函数");
            int flag=ps.executeUpdate();
            System.out.println("flag="+flag);
            if(flag==0){
            	//����
                System.out.println("Save data : No. = " + user.getId() + " , Name = " + user.getName());
            return false;
            }
            else
            {
            	//����ɹ�
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public  boolean insert_squestion(String sql, question sequestion) throws SQLException {
    	JdbcUtils jdbcutil=new JdbcUtils();
    	Connection conn=jdbcutil.getConnection();
    	//Connection conn=mysource.getConnection();	
        
        try {
            /*Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);*/
        	System.out.println("sql语句:"+sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, sequestion.getTespar_id());
            ps.setString(2, sequestion.getQue_des());
            ps.setString(3, sequestion.getChoice()); 
            ps.setString(4, sequestion.getAnswer()); 
            System.out.println("进入insert函数");
            int flag=ps.executeUpdate();
            System.out.println("flag="+flag);
            if(flag==0){
            	//����
                System.out.println("插入失败" );
            return false;
            }
            else
            {
            	//����ɹ�
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public  boolean insert_jquestion(String sql, question jdquestion) throws SQLException {
    	JdbcUtils jdbcutil=new JdbcUtils();
    	Connection conn=jdbcutil.getConnection();
    	//Connection conn=mysource.getConnection();	
        
        try {
            /*Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);*/
        	System.out.println("sql语句:"+sql);
            ps = conn.prepareStatement(sql);
            System.out.println("答案是："+jdquestion.getAnswer()+"   长度是 "+jdquestion.getAnswer().length());
            ps.setString(1, jdquestion.getTespar_id());
            ps.setString(2, jdquestion.getQue_des());
            ps.setString(3, jdquestion.getAnswer()); 
            System.out.println("进入insert函数");
            int flag=ps.executeUpdate();
            System.out.println("flag="+flag);
            if(flag==0){
            	//����
                System.out.println("插入失败 ");
            return false;
            }
            else
            {
            	//����ɹ�
            	return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
/*
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List selectOne(String sql, Student student) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("no").equals(student.getNo()) || rs.getString("name").equals(student.getName())|| rs.getString("age").equals(student.getAge())){
                    list.add(1);
                }else{
                    list.add(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    */
    public static ResultSet selectAll(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName(Common.DRIVER);
            conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return rs;
    }

}