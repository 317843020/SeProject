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

import Entity.Squestion;
import Entity.Tpaper;
import Service.SService;
import Service.TService;
import net.sf.json.JSONObject;

	@WebServlet("/Getxuanpaper")
	public class Getxuanpaper  extends HttpServlet {

		SService sService = new SService(); 
		TService tService = new TService();
		private static final long serialVersionUID = 1L;
	       

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//String json = "{\"t\":[{\"m\":\"f\",\"ac\":\"sdf\",\"bc\":\"ff\",\"cc\":\"asdf\",\"rc\":\"a\"},{\"m\":\"dsf\",\"ac\":\"sadsa\",\"bc\":\"sada\",\"cc\":\"dzxczx\",\"rc\":\"a\"},{\"m\":\"sdfsdaf\",\"ac\":\"ssdfdsfa\",\"bc\":\"sadsdfa\",\"cc\":\"dzxsdfdsfczx\",\"rc\":\"a\"}]}";
			//System.out.println(json);
			//System.out.println("==========================");
			
			//if(request.getSession().getAttribute("flag")!=null){
				
				
				
				
				//response.getWriter().print("false");
				//return ;
				
				
			//}
			
			
			
			String kemu = request.getParameter("kemu");
			
			//System.out.println("kemu="+kemu);
		Tpaper tpaper =	tService.findpaperbykemu(kemu);
		//System.out.println("tpaperid"+tpaper.getId());
//	System.out.println("taper"+tpaper);
	//System.out.println(tpaper==null);
		if(tpaper==null){
			
		//	System.out.println("ooooooooooooooooooo");
			//request.getRequestDispatcher("/query.html").forward(request, response);
			response.getWriter().print("false");
			return ;
		}
		if(request.getSession().getAttribute("kemunow")==null)
			request.getSession().setAttribute("kemunow", kemu);
			
		else{
			request.getSession().removeAttribute("kemunow");
			request.getSession().setAttribute("kemunow", kemu);
		}
		
		if(request.getSession().getAttribute("paperid")==null)
			request.getSession().setAttribute("paperid", tpaper.getId());
			
		else{
			request.getSession().removeAttribute("paperid");
			request.getSession().setAttribute("paperid", tpaper.getId());
		}
			
			List<Squestion> squestionlist = sService.findsquestion(tpaper.getId());
			
			Map<String,String> map =null;
			Map<String,List<Map<String,String>>> maplist = new HashMap<String,List<Map<String,String>>>(0);
			List<Map<String,String>> listmap = new ArrayList<Map<String,String>>();
			int size = squestionlist.size();
			Squestion[] allsquestions = (Squestion[]) squestionlist.toArray(new Squestion[size]);
			for (int i=0;i<allsquestions.length;i++) {
				map =  new HashMap<String,String>(0);
				map.put("qid", allsquestions[i].getId());
				map.put("m",allsquestions[i].getQue_des());
				String abcd = allsquestions[i].getChoice();
				String[] xuanxiang = abcd.split(";");
				
				map.put("ac", xuanxiang[0]);
				map.put("bc", xuanxiang[1]);
				map.put("cc", xuanxiang[2]);
			//	map.put("xc","an"+allsquestions[i].getId());
				//if()
				//map.put("tc", "");
				
				listmap.add(map);
			}
			
		
			maplist.put("t", listmap);
			
			
			JSONObject jsonObject = JSONObject.fromObject(maplist);
			
			request.getSession().setAttribute("flag", "kaishi");
			response.getWriter().print(jsonObject);
			
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}


