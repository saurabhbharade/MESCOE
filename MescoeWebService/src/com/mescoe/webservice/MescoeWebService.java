package com.mescoe.webservice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.model.Company;
import com.model.CompanyCriteria;
import com.model.Student;
import com.service.CompanyCriteriaServiceImpl;
import com.service.CompanyServiceImpl;
import com.service.StudentServiceImpl;
import com.service.TpoAssistantServiceImpl;
@WebService
public class MescoeWebService {
	public List<Student> getListOfStudentFromMescoe(int cid,String cname,float salary,String designation,String location,float ssc,float hsc,float beaggregate,int backlog,int numrequired,int poolcampus,int critid,int yop,List<String> branch)
	{
		
		Company company=new Company(cid, backlog, numrequired, poolcampus, cname, designation, location, salary, ssc, hsc, beaggregate, null);
		new CompanyServiceImpl().addCompanyService(company);
		for(int i=0;i<branch.size();i++)
		{
			new CompanyCriteriaServiceImpl().addCompanyCriteriaService(company, yop, branch.get(0));
		}
		
		List<CompanyCriteria> companyCriteriaList = new CompanyCriteriaServiceImpl().getCompanyCriteriaService(cid);
		return new TpoAssistantServiceImpl().getStudentEligibileForCompany(companyCriteriaList);

		//	List<CompanyCriteria> companyCriteriaList=new ArrayList<CompanyCriteria>();


		//	for(int i=0;i<companyCriteriaObjectList.size();i++)
		//	{
		//		CompanyCriteria companyCriteria=(CompanyCriteria)companyCriteriaObjectList.get(i);
		//		companyCriteriaList.add(companyCriteria);	
		//	}
//		List<CompanyCriteria> companyCriteriaList2=companyCriteriaList;
		//return new TpoAssistantServiceImpl().getStudentEligibileForCompany(companyCriteriaList);
		//new StudentServiceImpl().getAllStudentService();
	}	
}