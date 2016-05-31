package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Grade;
import Service.GradeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryGrade
 */
@WebServlet("/QueryGrade")
public class QueryGrade extends HttpServlet {
	
	GradeService gardeservice = new GradeService();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// "{\"ti\":[{\"timu\":\"shuxue\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=数学\",\"judge\":\"http://localhost:8080/maven/GetPanpaper?kemu=shuxu\"},{\"timu\":\"yuwen\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yuwen\",\"judge\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yuwen\"},{\"timu\":\"yinyu\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yinyu\",\"judge\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yinyu\"}]}";
        //"{\"c\": [{\"name\": \"高数\",\"num\": \"80\"},{\"name\": \"大学英语.\",\"num\": \"60\"}]}";
		String studentid = (String) request.getSession().getAttribute("student_id");
	//	System.out.println("ID"+studentid);
		List<Grade> allgrade = gardeservice.findgradebystudentid("1");
		//System.out.println("0000000243454533333333");System.out.println("000000000wert33333");
	//	System.out.println("00000t4twr3333333333");System.out.println("000000gessdfgdf33333333");
	//	System.out.println(allgrade.size());
		

		
		Map<String,String> map =null;
		Map<String,List<Map<String,String>>> maplist = new HashMap<String,List<Map<String,String>>>(0);
		List<Map<String,String>> listmap = new ArrayList<Map<String,String>>();
	
		int size = allgrade.size();
		Grade[] allgrades = (Grade[]) allgrade.toArray(new Grade[size]);
		for (int i=0;i<allgrades.length;i++) {
		/*	if(!map.isEmpty()){
				map.clear();
				System.out.println("mapsize"+map.size());
				
			}*/
			map =  new HashMap<String,String>(0);
			map.put("name",allgrades[i].getObject());
			map.put("num", allgrades[i].getGrade());
			
			listmap.add(map);
		}
		
		maplist.put("c", listmap);
		
		
		JSONObject jsonObject = JSONObject.fromObject(maplist);
		

		System.out.println(jsonObject);


		response.getWriter().print(jsonObject);/*
		System.out.println(allgrade.toString());
		response.getWriter().print(JSONArray.fromObject(allgrade));*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
