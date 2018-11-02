package com.service;

import java.util.List;

import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.dao.EnrollmentExistsException;
import com.model.Company;
import com.model.CompanyCriteria;
import com.model.Enrollment;
import com.model.Student;

public class EnrollmentServiceImpl implements EnrollmentService{
	EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
	
	/**
	 * Function definition that returns a list of companies that a student has enrolled in
	 * based on the student's unique identification named as sid in the table Student of the
	 * database called mescoe.
	 */
	@Override
	public List<Company> companiesEnrolledByStudentService(int sid) {
		return enrollmentDao.companiesEnrolledByStudent(sid);

	}
	
	/**
	 * Function definition that returns whether the student is eligible to enroll
	 * for a specific company in the table Enrollment of the database mescoe.
	 * of the database mescoe.
	 */
	@Override
	public boolean addEnrollmentService(Student student,Company company) {
		
		try {

			if(student.getSsc()<company.getSsc())
				return false;
			if(student.getHsc()<company.getHsc())
				return false;
			if(student.getBeaggregate()<company.getBeaggregate())
				return false;
			if(student.getBacklog()>company.getBacklog())
				return false;
			if(student.getHsc()<company.getHsc())
				return false;
			int flag=0;
			List<CompanyCriteria> companyCriteriaList = new CompanyCriteriaServiceImpl().getCompanyCriteriaService(company.getCid());
			for(CompanyCriteria companyCriteria:companyCriteriaList)
			{
				flag=0;
				if(companyCriteria.getYop()==student.getYop())
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
				return false;

			for(CompanyCriteria companyCriteria:companyCriteriaList)
			{
				flag=0;
				if(companyCriteria.getBranch().equalsIgnoreCase(student.getBranch()))
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
				return false;
			List<Enrollment> allEnrollmentList = new EnrollmentDaoImpl().getAllEnrollments();
			int size = allEnrollmentList.size()-1;
			int lasteid = allEnrollmentList.get(size).getEid();
			Enrollment enroll=new Enrollment(lasteid++, student, company);
			new EnrollmentDaoImpl().addEnrollment(enroll);
			return true;


		} catch (EnrollmentExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Function definition that returns a list of students that have enrolled in a company
	 * based on the company's unique identification named as cid in the table Company of the
	 * database called mescoe.
	 */
	@Override
	public List<Student> studentsEnrolledInACompanyService(int cid) 
	{

		return enrollmentDao.enrolledStudentInCompany(cid);
	}

}
