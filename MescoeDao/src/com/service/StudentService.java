package com.service;


import java.util.List;

import com.model.Student;

/**
 * Interface class that has the following methods
 * @author Administrator
 *
 */
public interface StudentService {
	
	/**
	 * Function declaration for getStudentService
	 * that return details of a student based on student id
	 * @param sid
	 * @return Student
	 */
	public Student getStudentService(int sid);
	
	/**
	 * Function declaration for getAllStudentService
	 * that returns a list of all students in the database
	 * @return List<Student>
	 */
	public List<Student>getAllStudentService();
	
	/**
	 * Function declaration for getPlacedStudent 
	 * that returns a list of students that have got placed
	 * @return List<Student>
	 */
	public List<Student> getPlacedStudent();
	
	/**
	 * Function declaration for getUnplacedStudent 
	 * that returns a list of students that have not got placed
	 * @return List<Student>
	 */
	public List<Student> getUnplacedStudent();
	
	/**
	 * Function declaration for addStudentService
	 * that adds a student in the database
	 * @param student
	 */
	public void addStudentService(Student student);
}
