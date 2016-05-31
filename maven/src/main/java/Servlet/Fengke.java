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

import Service.TService;
import net.sf.json.JSONObject;

@WebServlet("/Fengke")
public class Fengke extends HttpServlet {

	TService tService = new TService();

	private static final long serialVersionUID = 1L;
       
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String json = "{\"ti\":[{\"timu\":\"shuxue\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=数学\",\"judge\":\"http://localhost:8080/maven/GetPanpaper?kemu=shuxu\"},{\"timu\":\"yuwen\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yuwen\",\"judge\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yuwen\"},{\"timu\":\"yinyu\",\"choice\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yinyu\",\"judge\":\"http://localhost:8080/maven/Getxuanpaper?kemu=yinyu\"}]}";
	
		List<String> allkemu = tService.findkemu();
	//	System.out.println(allkemu.size());
		
		String choiceurl= "http://localhost:8080/maven/Getxuanpaper";
		String Panurl ="http://localhost:8080/maven/GetPanpaper";
		Map<String,String> map =null;
		Map<String,List<Map<String,String>>> maplist = new HashMap<String,List<Map<String,String>>>(0);
		List<Map<String,String>> listmap = new ArrayList<Map<String,String>>();
	
		int size = allkemu.size();
		String[] allkemus = (String[]) allkemu.toArray(new String[size]);
		for (int i=0;i<allkemus.length;i++) {
		/*	if(!map.isEmpty()){
				map.clear();
				System.out.println("mapsize"+map.size());
				
			}*/
			map =  new HashMap<String,String>(0);
			map.put("timu",allkemus[i]);
			map.put("choice", choiceurl+"?kemu="+allkemus[i]);
			map.put("judge", Panurl+"?kemu="+allkemus[i]);
			
			listmap.add(map);
		}
		
		maplist.put("ti", listmap);
		
		
		JSONObject jsonObject = JSONObject.fromObject(maplist);
		
		response.getWriter().print(jsonObject);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}