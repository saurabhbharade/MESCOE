package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.CompanyExistsException;
import com.model.Company;

public class CompanyServiceImpl implements CompanyService{
	CompanyDao companyDao=new CompanyDaoImpl();

	/**
	 * Function definition for addCompanyService to add details 
	 * of a company using the company's object.
	 */
	@Override
	public void addCompanyService(Company company) {
		/**
		 * Using companyDao's function to add details of a company
		 */
		try {
			companyDao.addCompany(company);
		} catch (CompanyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Function definition of getAllCompanyService that returns a list of all 
	 * the companies in the table name Company of the database mescoe.
	 */
	@Override
	public List<Company> getAllCompanyService() {
		// TODO Auto-generated method stub
		
		return companyDao.getAllCompanies();
	}
	
	/**
	 * Function definition of getCompanyByYear that returns a list of companies 
	 * visited in the college in that particular year based on the year passed as the parameter.
	 */
	@Override
	public List<Company> getCompanyByYear(int year) {
		List<Company> companyByYearList=new ArrayList<Company>();
		List<Company> allCompanyList = getAllCompanyService();
		for(Company company:allCompanyList)
		{
			
			int yearOfCampus = company.getDate_of_campus().getYear();
			yearOfCampus=yearOfCampus+1900; // by default 1900 will be subtracted
			if(yearOfCampus==year)
			{
				companyByYearList.add(company);
			}
		}
		return companyByYearList;
	}
	
	/**
	 * Function definition of checkCompanyService to check whether the company exists in 
	 * the table called Company of the database mescoe.
	 */
	@Override
	public boolean checkCompanyService(int cid) {
		Company company = new CompanyServiceImpl().getCompanyService(cid);
		if(company==null)
			return false;
		else
			return true;
	}
	
	/**
	 * Function definition of getCompanyService to get the details of a company based 
	 * on the parameter passed which is company Id named cid in the table company of the database mescoe.
	 */
	@Override
	public Company getCompanyService(int cid) {

		return companyDao.getCompany(cid);
	}

}
