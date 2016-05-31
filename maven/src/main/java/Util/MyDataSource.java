package Util;



import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;




/** 
 * ��д��׼������Դ��
 * 1��ʵ��DataSource �ӿ�
 * 2����ȡ��ʵ����Ĺ��췽����������ȡConnection ���󣬲�����ЩConnection �洢
 * ��LinkedList �����С�
 * 3��ʵ��getConnection() ����������ʱ����LinkedList������Connection������û���
 * 
 */
public class MyDataSource implements DataSource{
    private static String url = null;
    private static String password = null;
    private static String user = null ;
    private static String DriverClass = null;
    private static LinkedList<Connection> pool = new LinkedList<Connection>() ;

    //    ע�����ݿ�����
    static {
        try {  
          
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    		
            DriverClass = bundle.getString("driverClass");
    		url = bundle.getString("url");
    		user = bundle.getString("username");
    		password = bundle.getString("password");
    		Class.forName(DriverClass);
            //��ʼ�������������ӳ�
            for(int i = 0 ; i < 100 ; i ++) {
                Connection conn = (Connection) DriverManager.getConnection(url, user, password);
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }  
    }
    public MyDataSource ()  { 
        
    }

    //�������ӳػ�ȡ����:ͨ����̬����
    public Connection getConnection() throws SQLException {
        if (pool.size() > 0) {
            final Connection conn  = pool.removeFirst() ; 
           return  (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[] { Connection.class }, 
                    new InvocationHandler() {
                        //�������ģʽ��
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args)
                                throws Throwable {
                            if("close".equals(method.getName())){
                                //˭���ã�
                            	//System.out.println("����close��ִ�и�д�ķ��� ��ʱ��conncetion��"+conn);
                                		pool.add(conn);//������close����ʱ�������ˣ������ӷŻس�����
                                		return null;
                                
                            }else{
                                return method.invoke(conn, args);
                            } 
                        }
                    });
            
            
            
        }else {
            throw new RuntimeException("��������æ��"); 
        }
    } 
    
    public int getLength() {
        return pool.size() ;
    }
    
    
    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }
    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        
    }
    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        
    }
    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
    @Override
    public Connection getConnection(String username, String password)
            throws SQLException {
        return null;
    }

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	} 
}