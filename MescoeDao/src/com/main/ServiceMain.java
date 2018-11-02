package com.main;

import java.util.List;

import com.dao.CompanyCriteriaDaoImpl;
import com.model.Company;
import com.model.CompanyCriteria;
import com.model.Student;
import com.service.CompanyCriteriaServiceImpl;
import com.service.CompanyServiceImpl;
import com.service.EnrollmentServiceImpl;
import com.service.StudentServiceImpl;
import com.service.TpoAssistantServiceImpl;

public class ServiceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Company> companyByYear = new CompanyServiceImpl().getCompanyByYear(2017);
		System.out.println(companyByYear.size());
//		for(Company company:companyByYear)
//			System.out.println(company);
//		List<CompanyCriteria> companyCriteriaList = new CompanyCriteriaDaoImpl().getCompanyCriteria(2202);
//		boolean b = new TpoAssistantServiceImpl().checkStudentEligibiliyForCompanyWithCriteria(1101, companyCriteriaList);
//		System.out.println(b);
//			companyCriteriaList.get(0).setBranch(null);
//			companyCriteriaList.get(0).setYop(0);
		
	}

}
