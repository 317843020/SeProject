package Service;

import java.util.List;

import Dao.JDao;
import Entity.Jquestion;
import Entity.Squestion;

public class JService {
	JDao jDao = new JDao();

	public List<Jquestion> findjquestion(String paperid){
		List<Jquestion> jquestionlist= jDao.findquestion(paperid);
		System.out.println(jquestionlist);
		return jquestionlist;
				
	}
}
