package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.login_alter;
import Entity.p_user;
/*
 * ͨ���˺������û����͵�¼
 * */
@WebServlet("/login")
public class Login_Admin extends HttpServlet {
	
	login_alter login_al=new login_alter();
       
    public Login_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjj");
		p_user user=new p_user();
		user.setId(request.getParameter("user"));
		System.out.println(user.getId());
		user.setPassword(request.getParameter("password"));
		user.setType(request.getParameter("type"));
		request.getSession().setAttribute("type", request.getParameter("type"));
		
			try {
				if(login_al.login(user)){
					request.getSession().setAttribute("id",user.getId());
					//��¼�ɹ� ��
					System.out.println("ffffffffffffffff");
					request.getRequestDispatcher("/adchangs.html").forward(request,response);
				}
				else{
					System.out.println("ffffffffffwwwwwwwwwwwwwwwwww");
					//��¼ʧ��
				}
			} catch (SQLException e) {
				// ��¼ʧ��
				e.printStackTrace();
			}
			
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
