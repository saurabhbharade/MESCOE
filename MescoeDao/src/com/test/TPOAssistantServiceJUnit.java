package com.JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.service.TpoAssistantServiceImpl;

public class TPOAssistantServiceJUnit {

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
	public void testCheckEligibilityOfStudentForCompany() 
	{
		TpoAssistantServiceImpl tpoAssistantService = new TpoAssistantServiceImpl();
		
		boolean actual = tpoAssistantService.checkEligibilityOfStudentForCompany(1101, 1201);
		boolean expected=false;
		assertEquals(expected, actual);
	}

	@Test
	public void testCheckEligibilityOfStudentForDreamStatus() 
	{
		TpoAssistantServiceImpl tpoAssistantService = new TpoAssistantServiceImpl();

		boolean actual = tpoAssistantService.checkEligibilityOfStudentForDreamStatus(1101);
		boolean expected = true;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetStudentEligibleForDreamStatus() 
	{
		TpoAssistantServiceImpl tpoAssistantService = new TpoAssistantServiceImpl();
		
		int actual = tpoAssistantService.getStudentEligibleForDreamStatus().size();
		int expected = 5;
		
		assertEquals(expected, actual);
	}

	

}
