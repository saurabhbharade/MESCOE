package com.JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.dao.EnrollmentExistsException;
import com.model.Student;
import com.service.CompanyService;
import com.service.CompanyServiceImpl;
import com.service.EnrollmentService;
import com.service.EnrollmentServiceImpl;

public class EnrollmentServiceJUnit {

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
	public void testGetAllEnrollments() 
	{
		EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
		try {
			int actual = enrollmentDao.getAllEnrollments().size();
			int expected = 6;
			
			assertEquals(expected, actual);
		} catch (EnrollmentExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Test
	public void testGetEnrollment() 
	{
//		fail("Not yet implemented");
	}

	@Test
	public void testAddEnrollment() 
	{
	}

	@Test
	public void testUpdateEnrollment() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEnrollment() {
//		fail("Not yet implemented");
	}

	@Test
	public void testEnrolledStudentInCompany() 
	{
		EnrollmentService enrollmentService = new EnrollmentServiceImpl();
		EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
		
		int expected = enrollmentDao.enrolledStudentInCompany(1201).size();
		int actual = enrollmentService.studentsEnrolledInACompanyService(1201).size();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCompaniesEnrolledByStudent() 
	{
		EnrollmentService enrollmentService = new EnrollmentServiceImpl();
		EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();
		
		int actual = enrollmentService.companiesEnrolledByStudentService(1101).size();
		
		int expected = enrollmentDao.companiesEnrolledByStudent(1101).size();
		
		assertEquals(expected, actual);
		
	}

}
