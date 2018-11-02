package com.service;

import java.util.List;

import com.model.Company;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface CompanyService {
	/**
	 * Function declaration for addCompanyService to add details 
	 * of a company using the company's object.
	 * @param company
	 */
	public void addCompanyService(Company company);
	
	/**
	 * Function declaration for getAllCompanyService that returns a list of all 
	 * the companies in the table name Company of the database mescoe.
	 * @return
	 */
	public List<Company>getAllCompanyService();
	
	/**
	 * Function declaration for getCompanyService to get the details of a company based 
	 * on the parameter passed which is company Id named cid in the table company of the database mescoe.
	 * @param cid
	 * @return
	 */
	public Company getCompanyService(int cid);
	
	/**
	 * Function declaration for getCompanyByYear that returns a list of companies 
	 * visited in the college in that particular year based on the year passed as the parameter.
	 * @param year
	 * @return
	 */
	public List<Company> getCompanyByYear(int year);
	
	/**
	 * Function declaration for checkCompanyService to check whether the company exists in 
	 * the table called Company of the database mescoe.
	 * @param cid
	 * @return
	 */
	public boolean checkCompanyService(int cid);
}
