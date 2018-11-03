package com.dao;

import java.util.List;

import com.model.Company;
import com.model.Enrollment;
import com.model.Student;


/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface EnrollmentDao 
{
	String TABLEenrollment="Enrollment",
			COLeid="eid",COLsid="sid",COLcid="cid";
	
	
	/**
	 * Function declaration for getAllEnrollments that returns the list of all the details of
	 * enrollment in the table Enrollment of the database mescoe.
	 * @return
	 * @throws EnrollmentExistsException
	 */
	List<Enrollment> getAllEnrollments()throws EnrollmentExistsException;
	
	/**
	 * Function declaration that returns the details of an enrollment based on the unique Identification Enrollment Id,
	 * eid from the table Enrollment of the database mescoe.
	 * @param eid
	 * @return
	 */
	Enrollment getEnrollment(int eid);
	
	/**
	 * Function declaration for addEnrollment to add the details of enrollment in the 
	 * table Enrollment of the database mescoe.
	 * @param e
	 * @return
	 */
	Enrollment addEnrollment(Enrollment e);
	
	
	/**
	 * Function declaration for updateEnrollment to update the details of enrollment in 
	 * the table Enrollment of the database mescoe.
	 * @param e
	 */
	void updateEnrollment(Enrollment e);
	
	/**
	 * Function declaration for deleteEnrollment to delete the details of enrollment in 
	 * the table Enrollment of the database mescoe.
	 * @param e
	 */
	void deleteEnrollment(Enrollment e);

	/**
	 * Function declaration for enrolledStudentInCompany that returns the list of students 
	 * enrolled in a particular company based on the unique identifier Company Id, cid passed 
	 * as a parameter.
	 * @param cid
	 * @return
	 */
	public List<Student> enrolledStudentInCompany(int cid);
	
	/**
	 * Function declaration for companiesEnrolledByStudent that returns the list of companies 
	 * enrolled by a particular student based on the unique identifier Student Id, sid passed 
	 * as a parameter. 
	 * @param sid
	 * @return
	 */
	public List<Company> companiesEnrolledByStudent(int sid);
	
}
