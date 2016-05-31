package Util;

/**
 * 
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Entity.p_user;
import Entity.question;


/**
 * @author Hongten
 * @created 2014-5-18
 */
public class SaveData2DB {

    public void save_student(String xlspath) throws IOException, SQLException {
        ReadExcel xlsMain = new ReadExcel();
        p_user user = null;
        List<p_user> list = xlsMain.readXls_user(xlspath);
        DbUtil dbu=new DbUtil();
        String sql="insert into student(student_id, name, sex) values( ?, ?, ?)";
        System.out.println("sql执行语句"+ sql);
        System.out.println("列表长度："+list.size());
        for (int i = 0; i < list.size(); i++) {           
            if (dbu.insert_student(sql, list.get(i))) {
            	
            } else {
                System.out.println("The Record was Exist : No. = " + user.getId() );
            }
        }
    }
    public void save_Judgequestion(String xlspath) throws IOException, SQLException {
    	 ReadExcel xlsMain = new ReadExcel();
         p_user user = null;
         List<question> list = xlsMain.readXls_judgequestion(xlspath);
         DbUtil dbu=new DbUtil();
         String sql="insert into jquestion(tespar_id, que_des, answer) values( ?, ?, ?)";
         System.out.println("sql执行语句"+ sql);
         System.out.println("列表长度："+list.size());
         for (int i = 0; i < list.size(); i++) {           
             if (dbu.insert_jquestion(sql, list.get(i))) {
             	
             } else {
                 System.out.println("The Record was Exist : No. = " + user.getId() );
             }
         }
    }
     public void save_Selectquestion(String xlspath) throws IOException, SQLException {
    	 ReadExcel xlsMain = new ReadExcel();
         p_user user = null;
         List<question> list = xlsMain.readXls_Selectquestion(xlspath);
         DbUtil dbu=new DbUtil();
         String sql="insert into squestion(tespar_id, que_des, choice,answer) values( ?, ?, ?, ?)";
         System.out.println("sql执行语句"+ sql);
         System.out.println("列表长度："+list.size());
         for (int i = 0; i < list.size(); i++) {           
             if (dbu.insert_squestion(sql, list.get(i))) {
             	
             } else {
                 System.out.println("The Record was Exist : No. = " + user.getId() );
             }
         }
    }
    
}