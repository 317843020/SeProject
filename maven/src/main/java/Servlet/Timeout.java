package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Tpaper;
import Service.TService;

@WebServlet("/Timeout")
public class Timeout extends HttpServlet {

	TService tService = new TService();

	private static final long serialVersionUID = 1L;
       
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paperid = (String)request.getSession().getAttribute("paperid");
		Tpaper tpaper = tService.findpaperbyid(paperid);
		System.out.println("00000000000000000000000000000000");
		System.out.println(paperid);
		String timeStr1 = tpaper.getEndtime();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long date1;
		try {
			date1 = sdf.parse(timeStr1).getTime();
			long date2=new Date().getTime();
			long chatime = (date1-date2)/1000;
			System.out.println(chatime);//为差值
			response.getWriter().print(chatime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算过了多少秒  用（date1-date2）/1000 便可。
		//String timeout =  tpaper.getEndtime()tpaper.getStarttime();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}