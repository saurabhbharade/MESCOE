package com.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CompanyCriteria;
import com.pvg.webservice.PvgWebService;
import com.pvg.webservice.PvgWebService_Service;
import com.pvg.webservice.Student;
import com.service.CompanyCriteriaServiceImpl;
import com.service.StudentServiceImpl;
import com.sun.org.apache.xpath.internal.compiler.OpMapVector;

/**
 * Servlet implementation class GetStudentFromOtherCollege
 */
@WebServlet("/GetStudentFromOtherCollege")
public class GetStudentFromOtherCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentFromOtherCollege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(true);
		String tempcid=request.getParameter("cid");
		int cidforCompany=Integer.parseInt(tempcid);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<CompanyCriteria> companyCriteriaList = new CompanyCriteriaServiceImpl().getCompanyCriteriaService(cidforCompany);
		response.getWriter().append("Served at: "+companyCriteriaList.size());
		int cid=companyCriteriaList.get(0).getCompany().getCid();
		String cname=companyCriteriaList.get(0).getCompany().getCname();
		float salary=companyCriteriaList.get(0).getCompany().getSalary();
		String designation=companyCriteriaList.get(0).getCompany().getDesignation();
		String location=companyCriteriaList.get(0).getCompany().getLocation();
		float ssc=companyCriteriaList.get(0).getCompany().getSsc();
		float hsc=companyCriteriaList.get(0).getCompany().getHsc();
		float beaggregate=companyCriteriaList.get(0).getCompany().getBeaggregate();
		int backlog=companyCriteriaList.get(0).getCompany().getBacklog();
		int numrequired=companyCriteriaList.get(0).getCompany().getNumrequired();
		int poolcampus=companyCriteriaList.get(0).getCompany().getPoolcampus();
		Date date_of_campus=companyCriteriaList.get(0).getCompany().getDate_of_campus();
		int critid=companyCriteriaList.get(0).getCritid();
		int yop=companyCriteriaList.get(0).getYop();
		int sizeofbranch=companyCriteriaList.size();
		List<String> branch=new ArrayList<String>();
		response.getWriter().append("Served at: "+sizeofbranch);
		for(int i=0;i<sizeofbranch;i++)
		{
			branch.add(companyCriteriaList.get(i).getBranch());
		}
		PvgWebService_Service pvgwebservice=new PvgWebService_Service();
		PvgWebService pvgWebServicePort = pvgwebservice.getPvgWebServicePort();
		List<Student> listOfStudentFromPvg = pvgWebServicePort.getListOfStudentFromPvg(cid, cname, salary, designation, location, ssc, hsc, beaggregate, backlog, numrequired, poolcampus, critid, yop, branch);
		int sizeOfStudentFromPvg = listOfStudentFromPvg.size();

		response.getWriter().append("list size before adding : "+listOfStudentFromPvg.size());

		List<com.model.Student> unplacedStudentList = new StudentServiceImpl().getUnplacedStudent();
		
		for(int i=0;i<sizeOfStudentFromPvg;i++)
		{
			int sid=listOfStudentFromPvg.get(i).getSid();
			int backlogOfStudent=listOfStudentFromPvg.get(i).getBacklog();
			int statusOfStudent=listOfStudentFromPvg.get(i).getStatus();
			String passwordOfStudent=listOfStudentFromPvg.get(i).getPassword();
			String sname=listOfStudentFromPvg.get(i).getSname();
			String branchOfStudent=listOfStudentFromPvg.get(i).getBranch();
			String instituteNameOfStudent=listOfStudentFromPvg.get(i).getInstituteName();
			String email=listOfStudentFromPvg.get(i).getEmail();
			long phone=listOfStudentFromPvg.get(i).getPhone();
			int yopOfStudent=listOfStudentFromPvg.get(i).getYop();
			float sscMarksOfStudent=listOfStudentFromPvg.get(i).getSsc();
			float hscMarksOfStudent=listOfStudentFromPvg.get(i).getHsc();
			float beaggregateOfStudent=listOfStudentFromPvg.get(i).getBeaggregate();
			com.model.Student studentOfOtherCollege=new com.model.Student(sid, backlogOfStudent, statusOfStudent, passwordOfStudent, sname, branchOfStudent, instituteNameOfStudent, email, phone, yopOfStudent, sscMarksOfStudent, hscMarksOfStudent, beaggregateOfStudent);
			unplacedStudentList.add(studentOfOtherCollege);

			
		}
		session.setAttribute("ListofStudents", unplacedStudentList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("StudentList1.jsp");
		requestDispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
