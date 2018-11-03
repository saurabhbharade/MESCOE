package com.JUnitTest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.model.Company;
import com.service.CompanyService;
import com.service.CompanyServiceImpl;

public class CompanyServiceJUnit {

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
	public void testAddCompanyService() 
	{
		CompanyService companyService = new CompanyServiceImpl();
		CompanyDao companyDao = new CompanyDaoImpl();
		
		Company company = new Company(1208, 0, 40, 1, "HCL", "Software Developer", "Pune", 4.5f, 80.5f, 70.4f, 68.6f,Date.valueOf("2018-06-27"));
		companyService.addCompanyService(company);
		
		 int expected = companyDao.getAllCompanies().size();
		 int actual = companyService.getAllCompanyService().size();
		 
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAllCompanyService() 
	{
		CompanyService companyService = new CompanyServiceImpl();
		CompanyDao companydao = new CompanyDaoImpl();
		
		int expected = companydao.getAllCompanies().size();
		int actual = companyService.getAllCompanyService().size();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCompanyByYear() 
	{
		CompanyService companyService = new CompanyServiceImpl();
		CompanyDao companydao = new CompanyDaoImpl();
		
		int expected = companyService.getCompanyByYear(2018).size();
		int actual = 4;
		assertEquals(expected, actual);
		
	}

	@Test
	public void testCheckCompanyService() 
	{
		CompanyService companyService = new CompanyServiceImpl();
		
		boolean expected = companyService.checkCompanyService(1201);
		boolean actual = true;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetCompanyService() 
	{
		CompanyService companyService = new CompanyServiceImpl();
		CompanyDao companydao = new CompanyDaoImpl();
		
		
		boolean expected = companyService.checkCompanyService(1201);
		
		boolean actual = true;
		
		assertEquals(expected, actual);
	}

}
