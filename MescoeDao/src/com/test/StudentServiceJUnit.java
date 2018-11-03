package com.JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class StudentServiceJUnit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStudentService() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetAllStudentService() 
	{
		StudentService studentService = new StudentServiceImpl();
		StudentDao studentDao = new StudentDaoImpl();
		
		int expected = studentDao.getAllStudents().size();
		int actual = studentService.getAllStudentService().size();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPlacedStudent() 
	{
		StudentService studentService = new StudentServiceImpl();
		StudentDao studentDao = new StudentDaoImpl();
		
		int actual = studentService.getPlacedStudent().size();
		int expected = 3;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetUnplacedStudent() 
	{
		StudentService studentService = new StudentServiceImpl();
		StudentDao studentDao = new StudentDaoImpl();
		
		int actual = studentService.getUnplacedStudent().size();
		int expected = 2;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testAddStudentService() {
//		fail("Not yet implemented");
	}

}
