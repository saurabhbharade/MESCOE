package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Company;
import com.model.CompanyCriteria;


/**
 * Class CompanyCriteriaDaoImpl that implements the interface CompanyCriteriaDao
 * @author Administrator
 *
 */
public class CompanyCriteriaDaoImpl implements CompanyCriteriaDao
{
	private static List<CompanyCriteria>allCompanyCriteriaList=new ArrayList<CompanyCriteria>();

	/**
	 * Function definition of getCompanyCriteria that returns the details of a company based on
	 * the Company Id, cid passed as the parameter.
	 */
	@Override
	public List<CompanyCriteria> getCompanyCriteria(int cid) 
	{
		List<CompanyCriteria>companyCriteriaList=new ArrayList<CompanyCriteria>();
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcompanyCriteria+" where "+COLcid+"="+"?"+";";
			PreparedStatement pst;
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);

			pst.executeQuery();
			ResultSet rs=pst.getResultSet();


			while(rs.next())
			{
				int critid = rs.getInt(COLcritid);
				int yop=rs.getInt(COLyop);
				String branch=rs.getString(COLbranch);
				CompanyCriteria companyCriteria=new CompanyCriteria(rs.getInt(COLcritid),new CompanyDaoImpl().getCompany(cid),rs.getInt(COLyop),rs.getString(COLbranch));
				companyCriteriaList.add(companyCriteria);
			}
			return companyCriteriaList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return companyCriteriaList;
	}

	/**
	 * Function definition of getAllCompanyCriteria that returns a list of all the companies
	 * in the table Company of the database mescoe.
	 */
	@Override
	public List<CompanyCriteria> getAllCompanyCriteria() 
	{
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcompanyCriteria+";";
			PreparedStatement pst;
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			//if(rs.next()==false)return null;
			while(rs.next())
			{
				int critid=rs.getInt(COLcritid);
				int cid1=rs.getInt(COLcid);
				int yop=rs.getInt(COLyop);
				String branch = rs.getString(COLbranch);
				CompanyCriteria companyCriteria=new CompanyCriteria(rs.getInt(COLcritid),new CompanyDaoImpl().getCompany(cid1), rs.getInt(COLyop),rs.getString(COLbranch));		
				allCompanyCriteriaList.add(companyCriteria);
			}
			return allCompanyCriteriaList;
		}

		catch (SQLException e) 
		{

			System.out.println(e);
		}
		return allCompanyCriteriaList;

	}

	/**
	 * Function definition of addCompanyCriteria that adds the details of a company
	 * in the table Company of the database mescoe
	 */
	@Override
	public void addCompanyCriteria(CompanyCriteria c) 
	{
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "insert into " + TABLEcompanyCriteria + " values (?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, c.getCritid());
			pst.setInt(2, c.getCompany().getCid());
			pst.setInt(3, c.getYop());
			pst.setString(4, c.getBranch());



			pst.executeUpdate();
			allCompanyCriteriaList.add(c);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}


	}

	/**
	 * Function definition of updateCompanyCriteria that updates the details of a company
	 * in the table Company of the database mescoe.
	 */
	@Override
	public void updateCompanyCriteria(CompanyCriteria c) {
		int cid = c.getCompany().getCid();
		int yop = c.getYop();
		int new_yop=c.getYop();
		String branch = c.getBranch();

		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="update "+ TABLEcompanyCriteria +" set "+COLcid+"=?, "+COLyop+"=?, "+COLbranch+"=? where "+COLcritid+"=?";
			pst = connection.prepareStatement(sqlQuery);



			pst.setInt(1,c.getCompany().getCid());
			pst.setInt(2,c.getYop());
			pst.setString(3,c.getBranch());
			pst.setInt(4,c.getCritid());

			pst.executeUpdate();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}

	/**
	 * Function definition of deleteCompanyCriteria that deletes the details of a company
	 * in the table Company of the database mescoe.
	 */
	@Override
	public void deleteCompanyCriteria(CompanyCriteria c) 
	{
		PreparedStatement pst;
		try 
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEcompanyCriteria+" where "+COLcid+"=?";
			pst = connection.prepareStatement(sqlQuery);

			pst.setInt(1,c.getCompany().getCid());
			int executeUpdate = pst.executeUpdate();

			allCompanyCriteriaList.remove(c);


		}
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}



}
