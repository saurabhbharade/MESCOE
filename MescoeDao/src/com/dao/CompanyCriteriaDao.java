package com.dao;

import java.util.List;

import com.model.Company;
import com.model.CompanyCriteria;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface CompanyCriteriaDao 
{
	String TABLEcompanyCriteria="CompanyCriteria",
			COLcritid="critid",
			COLyop="yop", COLbranch="branch", COLcid="cid";
	
	/**
	 * Function declaration for getCompanyCriteria that returns the details of a company criteria
	 * based on the Company Id passed as the parameter
	 * @param cid is the company Id for the table Company of the database mescoe
	 * @return
	 */
	List<CompanyCriteria> getCompanyCriteria(int cid);
	
	/**
	 * Function declaration for getAllCompanyCriteria that returns a list of all the company criterias
	 * in the table CompanyCriteria of the database mescoe.
	 * @return
	 */
	List<CompanyCriteria> getAllCompanyCriteria();
	
	/**
	 * Function declaration for addCompanyCriteria that adds the details of a company
	 * in the table Company of the database mescoe
	 * @param c
	 */
	void addCompanyCriteria(CompanyCriteria c);
	
	/**
	 * Function declaration for updateCompanyCriteria that updates the details of a company criteria
	 * in the table Company of the database mescoe
	 * @param c
	 */
	void updateCompanyCriteria(CompanyCriteria c);
	
	/**
	 * Function declaration for deleteCompanyCriteria that deletes the details of a company criteria
	 * in the table Company of the database mescoe
	 * @param c
	 */
	void deleteCompanyCriteria(CompanyCriteria c);
}
