package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.login_alter;
import Entity.p_user;

/*
 * ͨ���û������˺�ԭ���� ������ �޸�����
 * */
@WebServlet("/alter_pwd")
public class alter_pwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	login_alter login_al=new login_alter();
	
    public alter_pwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		p_user user=new p_user();
		String new_pw=request.getParameter("newPw");
		user.setId((String)request.getSession().getAttribute("id"));
		user.setPassword(request.getParameter("originalPw"));
		user.setType((String)request.getSession().getAttribute("type"));
		try {
			if(login_al.alter_pw(user,new_pw))
			{
				System.out.println("jjjjjjjjjjjjjjj");
				response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				 out.println(" <script type='text/javascript'> alert('修改成功')</script>");
				 out.println("</HTML>");
				 request.getRequestDispatcher("/adchangpw.html");
			}
			else 
			{
				//�޸�ʧ��
				System.out.println("ffffffffffffffffffeeeeeeeeeeee");
			}
		} catch (SQLException e) {
			//�޸�ʧ��
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
