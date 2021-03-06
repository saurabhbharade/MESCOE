package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Company;
import com.service.CompanyService;
import com.service.CompanyServiceImpl;

/**
 * Servlet implementation class CompaniesVisitedInAYear
 */
@WebServlet("/CompaniesVisitedInAYear")
public class CompaniesVisitedInAYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompaniesVisitedInAYear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
		HttpSession session = request.getSession(true);
		String year_in_string = request.getParameter("year");
		int year_in_int = Integer.parseInt(year_in_string);
		
		CompanyService companyService = new CompanyServiceImpl();
		List<Company> companyByYear = companyService.getCompanyByYear(year_in_int);
		session.setAttribute("CompanyCriteriaList", companyByYear);
		response.getWriter().append(""+companyByYear.size());
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewCompanyCriteriaDisplay.jsp");
		 requestDispatcher.forward(request, response);
		}
		catch(NumberFormatException e)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("TPOHomePage.jsp");
			requestDispatcher.forward(request, response);
		}
		catch(NullPointerException e)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("TPOHomePage.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
