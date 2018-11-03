package com.dao;

import java.util.List;

import com.model.Company;


/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface CompanyDao 
{
	String TABLEcompany = "Company", COLcid = "cid", COLcname = "cname",
			COLbacklog = "backlog", COLnumrequired = "numrequired",
			COLpoolcampus = "poolcampus", COLdesignation="designation",
			COLlocation="location", COLsalary = "salary",
			COLssc="ssc", COLhsc="hsc", COLbeaggregate="beaggregate", COLdate_of_campus="date_of_campus";


	/**
	 * Function declaration for getCompany that returns the details of a company based on the
	 * Company Id,cid passed as a parameter.
	 * @param cid
	 * @return
	 */
	Company getCompany(int cid);
	
	/**
	 * Function declaration for getAllCompanies that returns the list of all the companies 
	 * in the table Company from the database mescoe.
	 * @return
	 */
	List<Company> getAllCompanies();
	
	/**
	 * Function declaration for addCompany that adds the details of a company in the 
	 * table Company from the database mescoe.
	 * @param c
	 * @throws CompanyExistsException
	 */
	void addCompany(Company c) throws CompanyExistsException;
	
	/**
	 * Function declaration for updateCompany that updates the details of a company in the 
	 * table Company from the database mescoe.
	 * @param c
	 * @throws CompanyExistsException
	 */
	void updateCompany(Company c) throws CompanyExistsException;
	
	/**
	 * Function declaration for deleteCompany that deletes the details of a company in the 
	 * table Company from the database mescoe.
	 * @param c
	 * @throws CompanyExistsException
	 */
	void deleteCompany(Company c) throws CompanyExistsException;
}
