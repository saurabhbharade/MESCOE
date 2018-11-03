package com.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CompanyCriteriaDao;
import com.dao.CompanyCriteriaDaoImpl;
import com.dao.CompanyDaoImpl;
import com.model.Company;
import com.model.CompanyCriteria;
import com.service.CompanyCriteriaService;
import com.service.CompanyCriteriaServiceImpl;

public class CompanyCriteriaTest {

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
	public void testGetCompanyCriteriaService() {
		CompanyCriteriaService companyCriteria = new CompanyCriteriaServiceImpl();
		CompanyCriteriaDao companyCriteriaDao = new CompanyCriteriaDaoImpl();
		int actual = companyCriteria.getCompanyCriteriaService(1201).size();
		int expected = 1;
		assertEquals(expected, actual);
	}
}
