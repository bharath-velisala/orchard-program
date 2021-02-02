package com.mindtree.orchardstudents.daoLayer.daoLayerImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mindtree.orchardstudents.daoLayer.DaoException;
import com.mindtree.orchardstudents.daoLayer.daoLayer;
import com.mindtree.orchardstudents.entity.Employee;

public class DaoImpl implements daoLayer {

	final static String driverclass = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://localhost:3306/employee";
	final static String username = "root";
	final static String password = "Pixel@6444";
	static Connection con;
	static PreparedStatement st;
	static {
		try {
			Class.forName(driverclass);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void addData(int id, String name, String track, int count, String mobilenumber, String role)
			throws DaoException {

		try {
			String Query = "insert into Employee_details VALUES('" + id + "','" + name + "','" + track + "','" + count
					+ "','" + mobilenumber + "','" + role + "')";
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void countupdatesql(int count, String track) throws DaoException {
		String Query = "update Employee_details SET numbers_of_minds='" + count + "' where Track='" + track + "'";
		try {
			st = con.prepareStatement(Query);
			st.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
	}

	public void deletedata(int id, int count, String track) throws DaoException {
		String Query = "delete from employee_details where employee_id='" + id + "'";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countupdatesql(id, track);
	}

	public void updateMobilenumber(String phonenumber, int id) throws DaoException {
		String Query = "update employee_details set PhoneNumber='" + phonenumber + "' where Employee_id='" + id + "'";
		try {
			st = con.prepareStatement(Query);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> previousdata(List<Employee> employee) throws DaoException {

		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Employee_details");
			while (result.next()) {
				Employee employee1 = new Employee();
				employee1.setEmployee_Id(result.getInt("Employee_id"));
				employee1.setEmployee_Name(result.getString("Employee_Name"));
				employee1.setTrack(result.getString("Track"));
				employee1.setNumber_Of_Minds(result.getInt("numbers_of_minds"));
				employee1.setPhoneNumber(result.getString("PhoneNumber"));
				employee1.setRole(result.getString("role"));

				employee.add(employee1);
			}
		} catch (SQLException e) {
		}
		return employee;
	}
}
