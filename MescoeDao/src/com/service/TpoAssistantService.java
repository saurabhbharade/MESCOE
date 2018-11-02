package com.service;

import java.util.List;

import com.model.CompanyCriteria;
import com.model.Student;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface TpoAssistantService {
	
	/**
	 * Function declaration for the function checkEligibilityOfStudentForCompany
	 * which determines whether a student is eligible to enroll for a company
	 * 
	 * @param sid
	 * @param cid
	 * @return boolean
	 */
	public boolean checkEligibilityOfStudentForCompany(int sid,int cid);
	
	/**
	 * Function declaration for checkEligibilityOfStudentForDreamStatus
	 * which checks the eligibility of a student for company with dream status
	 * i.e. salary>5
	 * @param sid
	 * @return boolean
	 */
	public boolean checkEligibilityOfStudentForDreamStatus(int sid);
	
	/**
	 * Function declaration for getStudentEligibleForDreamStatus that
	 * returns a list of eligible students
	 * @return List<Student>
	 */
	public List<Student>getStudentEligibleForDreamStatus();

	/**
	 * Function declaration for checkStudentEligibiliyForCompanyWithCriteria
	 * which checks whether a student is eligible for a company based on the 
	 * criteria sent as a parameter
	 * @param sid
	 * @param companyCriteriaList
	 * @return boolean
	 */
	public boolean checkStudentEligibiliyForCompanyWithCriteria(int sid,List<CompanyCriteria> companyCriteriaList);

	/**
	 * Function declaration for getStudentEligibileForCompany
	 * which returns a list of students eligible for a company based on the criteria
	 * sent as a parameter
	 * @param companyCriteriaList
	 * @return
	 */
	public List<Student> getStudentEligibileForCompany(List<CompanyCriteria> companyCriteriaList);
}
