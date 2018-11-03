package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Company;
import com.model.Enrollment;
import com.model.Student;

public class EnrollmentDaoImpl implements EnrollmentDao
{


	private static List<Enrollment> allEnrollmentList=new ArrayList<Enrollment>();


	/**
	 * Function definition of getAllEnrollments that returns the list of all the details of
	 * enrollment in the table Enrollment of the database mescoe.
	 */
	@Override
	public List<Enrollment> getAllEnrollments() throws EnrollmentExistsException 
	{
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="select * from "+TABLEenrollment+";";

			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				int sid=rs.getInt(COLsid);
				int cid=rs.getInt(COLcid);
				Enrollment enroll=new Enrollment(rs.getInt(COLeid),new StudentDaoImpl().getStudent(sid),new CompanyDaoImpl().getCompany(cid));

				allEnrollmentList.add(enroll);


			}
			return allEnrollmentList;
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return allEnrollmentList;


	}

	/**
	 * Function definition that returns the details of an enrollment based on the unique 
	 * Identification Enrollment Id, eid from the table Enrollment of the database mescoe.
	 */
	@Override
	public Enrollment getEnrollment(int eid) 
	{
		try
		{
			Enrollment dummy = new Enrollment();
			dummy.setEid(eid);
			if(allEnrollmentList.contains(dummy))
			{
				int index=allEnrollmentList.indexOf(dummy);
				return allEnrollmentList.get(index);
			}

			Connection connection = DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEenrollment+" where "+COLeid+"="+"?";

			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, eid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			if(rs.next()==false)
			{
				return null;
			}
			int sid=rs.getInt(COLsid);
			Student student = new StudentDaoImpl().getStudent(sid);
			int cid=rs.getInt(COLcid);
			Company company = new CompanyDaoImpl().getCompany(cid);
			//int eid=rs.getInt(COLeid);
			Enrollment enrollment=new Enrollment(eid,student,company);
			allEnrollmentList.add(enrollment);
			return enrollment;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Function definition of addEnrollment to add the details of enrollment in the 
	 * table Enrollment of the database mescoe.
	 */
	@Override
	public Enrollment addEnrollment(Enrollment e) 
	{
		try
		{
			Connection connection = DBConnection.getConnection();
			String sqlQuery = "insert into " + TABLEenrollment + " values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(3, e.getCompany().getCid());
			pst.setInt(1, e.getEid());
			pst.setInt(2, e.getStudent().getSid());


			pst.executeUpdate();
			allEnrollmentList.add(e);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}



		return null;
	}

	/**
	 * Function definition for updateEnrollment to update the details of enrollment in 
	 * the table Enrollment of the database mescoe.
	 */
	@Override
	public void updateEnrollment(Enrollment e) 
	{
		int sid=e.getStudent().getSid();
		int cid=e.getCompany().getCid();
		int eid=e.getEid();
		try{
			Connection connection=DBConnection.getConnection();
			//String sqlquery="update "+TABLEEnrollment+" set "+COlsname+"=?, "+COLinstitutename+"=? where sid="+sid+";";
			String sqlquery="update "+TABLEenrollment+" set "+COLsid+"=?, "+COLcid+"=?  where eid=? ";


			PreparedStatement pst=connection.prepareStatement(sqlquery);


			pst.setInt(1, e.getStudent().getSid());
			pst.setInt(2, e.getCompany().getCid());
			pst.setInt(3,e.getEid());

			int result=pst.executeUpdate();

			for(Enrollment enroll:allEnrollmentList)
			{
				if(enroll.getStudent().getSid()==sid&&enroll.getCompany().getCid()==cid)
				{

					enroll.getCompany().getCid();
					enroll.getStudent().getSid();
				}
			}



		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}


	}

	/**
	 * Function definition of deleteEnrollment to delete the details of enrollment in 
	 * the table Enrollment of the database mescoe.
	 */
	@Override
	public void deleteEnrollment(Enrollment e) 
	{
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEenrollment+" where "+COLeid+"=?";
			pst = connection.prepareStatement(sqlQuery);

			pst.setInt(1,e.getEid());
			int executeUpdate = pst.executeUpdate();

			allEnrollmentList.remove(e);


		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		allEnrollmentList.remove(e);

	}

	/**
	 * Function definition of enrolledStudentInCompany that returns the list of students 
	 * enrolled in a particular company based on the unique identifier Company Id, cid passed 
	 * as a parameter.
	 */
	@Override
	public List<Student> enrolledStudentInCompany(int cid) 
	{
		List<Student> studentsInCompany=new ArrayList<Student>();

		// TODO Auto-generated method stub
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="select * from student where sid in(select sid from enrollment where cid=?);";


			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.setInt(1, cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			while(rs.next())
			{
				int sid=rs.getInt("sid");
				Student s=new StudentDaoImpl().getStudent(sid);
				studentsInCompany.add(s);


			}
			return studentsInCompany;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return studentsInCompany;

	}

	/**
	 * Function definition of companiesEnrolledByStudent that returns the list of companies 
	 * enrolled by a particular student based on the unique identifier Student Id, sid passed 
	 * as a parameter.
	 */
	@Override
	public List<Company> companiesEnrolledByStudent(int sid) 
	{
		List<Company>CompanyList=new ArrayList<Company>();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEenrollment+" where "+COLsid+"="+"?";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			while(rs.next())
			{
				//int sid=rs.getInt(COLsid);
				int cid=rs.getInt(COLcid);
				//new CourseDaoImpl.getC(cid);
				CompanyList.add(new CompanyDaoImpl().getCompany(cid));
			}
			return  CompanyList;
		}catch (SQLException ex) {

			ex.printStackTrace();
		}
		return CompanyList;

	}

}
