package Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Grade;
import Entity.Jquestion;
import Entity.Squestion;
import Service.GradeService;
import Service.JService;
import Service.SService;
import Service.TService;

@WebServlet("/CountGrade")
public class CountGrade extends HttpServlet {

	TService tService = new TService();
	SService sService = new SService();
	JService jService = new JService();
	GradeService gradeService = new GradeService();
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		Map<String,String> smap = new HashMap<String,String>(0);
		Map<String,String> jmap = new HashMap<String,String>(0);
		String[] qids = request.getParameterValues("questionid");
		for (int i = 0; i < qids.length; i++) {
			String answer = request.getParameter("an"+qids[i]);
			System.out.println("answer"+answer);
			System.out.println("qid"+qids[i]);
			smap.put(qids[i],answer);
		}
		String[] jids = request.getParameterValues("jqid");
		for (int i = 0; i < jids.length; i++) {
			String janswer = request.getParameter("ju"+jids[i]);
			System.out.println("janswer"+janswer);
			System.out.println("jid"+jids[i]);
			jmap.put(jids[i], janswer);
		}
		
		
		System.out.println(smap);
		System.out.println(jmap);
		//String[] answers = request.getParameterValues("an");
		
		System.out.println("============");
		//System.out.println(answers);
		
		/*for (int i = 0; i < answers.length; i++) {
			System.out.println(answers[i]);
		}*/
		String paperid = (String) request.getSession().getAttribute("paperid");
		List<Squestion> slist = sService.findsquestion(paperid);
			
		for (int i = 0; i < qids.length; i++) {
			for (Squestion squestion : slist) {
				if(squestion.getId().equals(qids[i])&&	squestion.getAnswer().equals(smap.get(qids[i]))){
					count = count+5;
				}
			
			}
		}
		
		List<Jquestion> jlist = jService.findjquestion(paperid);
			
		for (int i = 0; i < jids.length; i++) {
			for (Jquestion jquestion : jlist) {
				if(jquestion.getId().equals(jids[i])&&	jquestion.getAnswer().equals(jmap.get(jids[i]))){
					count = count+4;
				}
			
			}
		}
		
		System.out.println("============");
		System.out.println("count"+count);
		
		String kemunow =  (String) request.getSession().getAttribute("kemunow");
		String studentid  = (String)request.getSession().getAttribute("student_id");
		
		Grade studentgrade = new Grade();
		studentgrade.setObject(kemunow);
		studentgrade.setPaper_id(paperid);
		studentgrade.setStudent_id("1");
		studentgrade.setGrade(Integer.toString(count));
		gradeService.add_grade(studentgrade);
		
		request.getRequestDispatcher("/query.html").forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
