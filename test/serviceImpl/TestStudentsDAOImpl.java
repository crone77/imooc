package serviceImpl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import service.StudentsDAO;
import entity.Students;

public class TestStudentsDAOImpl {
	@Test
	public void testQueryAllStudents() {
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}

	}

	@Test
	public void testGetNewSid() {
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	
	@Test
	public void testAddStudents(){
		Students s=new Students();
		s.setSname("ssss");
		s.setGender("male");
		s.setAddress("wuhan");
		s.setBirthday(new Date());
		StudentsDAO sdao=new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
	
	
}
