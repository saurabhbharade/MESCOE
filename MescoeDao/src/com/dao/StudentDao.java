package com.dao;

import java.util.List;

import com.model.Student;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface StudentDao 
{
	String TABLEStudent="Student",
			COLsid="sid",COLbacklog="backlog",
			COLstatus="status",COLpassword="password",COLsname="sname",
			COLbranch="branch",COLinstituteName="instituteName",COLemail="email",
			COLphone="phone",COLyearOfPassing="yop",COLssc="ssc",COLhsc="hsc",
			COLbeaggregate="beaggregate";

	/**
	 * Function declaration for getStudent to get details of a student based on the unique 
	 * Identifier Student Id, sid passed as a parameter.
	 * @param sid
	 * @return
	 */
	Student getStudent(int sid);
	List<Student> getAllStudents();
	
	/**
	 * Function declaration for addStudent to add details of a student in the table Student of
	 * the database mescoe.
	 * @param s
	 * @throws StudentExistsException
	 */
	void addStudent(Student s) throws StudentExistsException;
	
	/**
	 * Function declaration for updateStudent to update details of a student in the table Student of
	 * the database mescoe.
	 * @param s
	 */
	void updateStudent(Student s);
	
	/**
	 * Function declaration for deleteStudent to delete details of a student in the table Student of
	 * the database mescoe.
	 * @param s
	 */
	void deleteStudent(Student s);
}
