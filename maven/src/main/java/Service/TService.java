package Service;

import java.util.List;

import Dao.TDao;
import Entity.Tpaper;

public class TService {
	TDao tDao =  new TDao();
	
	public Tpaper findpaperbykemu(String kemu){
	
		Tpaper tpaper = tDao.findpaperBykemu(kemu);
		return tpaper;
	}
	
	public List<String> findkemu(){
		List<String> allkemu = tDao.findAllkemu();
		
		return allkemu;
		
				
	}
	
	public Tpaper findpaperbyid(String paperid){
		Tpaper tpaper = tDao.findpaperByid(paperid);
		return tpaper;
	}

}
