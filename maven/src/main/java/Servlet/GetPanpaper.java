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

import Entity.Jquestion;
import Entity.Tpaper;
import Service.JService;
import Service.TService;
import net.sf.json.JSONObject;

	@WebServlet("/GetPanpaper")
	public class GetPanpaper  extends HttpServlet {

		JService jService = new JService();
		TService tService = new TService();
		private static final long serialVersionUID = 1L;
	       

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//String json = "{\"t\":[{\"m\":\"sdfasdfasdf\",\"j\":\"T\"},{\"m\":\"sdfgdfafdgdfghnjnf\",\"j\":\"T\"},{\"m\":\"dfgdfg\",\"j\":\"T\"}]}";
			//System.out.println(json);
			Map<String,String> map =null;
			Map<String,List<Map<String,String>>> maplist = new HashMap<String,List<Map<String,String>>>(0);
			List<Map<String,String>> listmap = new ArrayList<Map<String,String>>();
			String kemu = request.getParameter("kemu");
			Tpaper tpaper =	tService.findpaperbykemu(kemu);
		//	System.out.println("Pannnnnnnnnnnnnnnnnnnnnnnn"+kemu);
		//	System.out.println("kkkkkkkkkmmmmmmmmmmmmmmmm id"+tpaper.getId());
			if(tpaper==null){
				
			//	System.out.println("oooooooooooooofffffffffffffffffffffffooooo");
				//request.getRequestDispatcher("/query.html").forward(request, response);
				response.getWriter().print("false");
				return ;
			}
			
			
			request.getSession().setAttribute("paperid", tpaper.getId());
			List<Jquestion> jquestionlist = jService.findjquestion(tpaper.getId());
			int size =jquestionlist.size();
			Jquestion[] allsquestions = (Jquestion[]) jquestionlist.toArray(new Jquestion[size]);
			for (int i=0;i<allsquestions.length;i++) {
				map =  new HashMap<String,String>(0);
				map.put("jid", allsquestions[i].getId());
				map.put("m",allsquestions[i].getQue_des());
				map.put("j", "T");
				
				listmap.add(map);
			}
			
		
			maplist.put("t", listmap);
			
			
			JSONObject jsonObject = JSONObject.fromObject(maplist);
			response.getWriter().print(jsonObject);
			
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}


