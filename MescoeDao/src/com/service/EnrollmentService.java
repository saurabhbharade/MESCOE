package com.service;

import java.util.List;

import com.model.Company;
import com.model.Enrollment;
import com.model.Student;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface EnrollmentService {

	/**
	 * Function declaration that returns a list of companies that a student has enrolled in
	 * based on the student's unique identification named as sid in the table Student of the
	 * database called mescoe.
	 * @param sid
	 * @return
	 */
	public List<Company> companiesEnrolledByStudentService(int sid);
	
	/**
	 * Function declaration that returns whether the student is eligible to enroll
	 * for a specific company in the table Enrollment of the database mescoe.
	 * of the database mescoe.
	 * @param student
	 * @param company
	 * @return
	 */
	public boolean addEnrollmentService(Student student,Company company);
	
	/**
	 * Function declaration that returns a list of students that have enrolled in a company
	 * based on the company's unique identification named as cid in the table Company of the
	 * database called mescoe.
	 * @param cid
	 * @return
	 */
	public List<Student> studentsEnrolledInACompanyService(int cid);

}
