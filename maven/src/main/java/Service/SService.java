package Service;

import java.util.List;

import org.junit.Test;

import Dao.SDao;
import Entity.Squestion;

public class SService {
	SDao sDao = new SDao();

	public List<Squestion> findsquestion(String paperid){
		List<Squestion> squestionlist= sDao.findquestion(paperid);
		System.out.println(squestionlist);
		return squestionlist;
				
	}
}
