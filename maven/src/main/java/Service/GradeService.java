package Service;

import java.util.List;

import Dao.GradeDao;
import Entity.Grade;;

public class GradeService {
	GradeDao gradeDao = new GradeDao();

	public List<Grade> findgradebystudentid(String studentid){
		List<Grade> gradelist= gradeDao.findGradebyStudentid(studentid);
		return gradelist;
	}
	
	public boolean add_grade(Grade studentgrade) {
		return gradeDao.Add(studentgrade);
	}

}
