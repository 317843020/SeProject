package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.manage_question;
import Entity.question;

/*
 * �ṩ�������ɾ������
 * 
 * */
@WebServlet("/update_question")
public class update_question extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	manage_question ma_que=new manage_question();
    public update_question() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String type=null;
		question ques=new question();
		ques.setQuesion_id(request.getParameter("quesion_id"));
		ques.setAnswer(request.getParameter("answer"));
		ques.setChoice(request.getParameter("choice"));
		ques.setQue_des(request.getParameter("que_des"));
		ques.setTespar_id(request.getParameter("tespar_id"));
		type=request.getParameter("type");
		try {
			if(ma_que.update(ques, type))
			{
				//��¼�ɹ�
			}
			else
			{
				//��¼ʧ��
			}
		} catch (SQLException e) {
			//��¼ʧ��
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
