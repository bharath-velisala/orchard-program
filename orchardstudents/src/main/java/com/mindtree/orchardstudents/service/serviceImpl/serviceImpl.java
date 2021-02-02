package com.mindtree.orchardstudents.service.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mindtree.orchardstudents.daoLayer.DaoException;
import com.mindtree.orchardstudents.daoLayer.daoLayerImpl.DaoImpl;
import com.mindtree.orchardstudents.entity.Employee;
import com.mindtree.orchardstudents.service.serviceInterface;

public class serviceImpl extends DaoImpl implements serviceInterface {
	Scanner sc = new Scanner(System.in);
	DaoImpl dao = new DaoImpl();

	public List<Employee> addEmployee(List<Employee> employee) throws Exception {
		System.out.println("enter Employee_id");
		int id = sc.nextInt();
		sc.nextLine();
		for (Employee e : employee) {
			while (id == e.getEmployee_Id()) {
				System.out.println("id already exists try another id");
				id = sc.nextInt();
				sc.nextLine();
			}
		}
		System.out.println("enter Employee_Name");
		String name = sc.nextLine();
		System.out.println("enter Track");
		String track = sc.nextLine();
		int count = updatecount(employee, track);
		System.out.println("enter mobilenumber");
		String mobilenumber = sc.nextLine();
		System.out.println("enter Role(Lead/CampusMind)");
		String role = sc.nextLine();
		employee.add(new Employee(id, name, track, count, mobilenumber, role));
		dao.addData(id, name, track, count, mobilenumber, role);
		dao.countupdatesql(count, track);
		return employee;
	}

	public List<Employee> deleteEmployee(List<Employee> employee){
		System.out.println("enter employee_Id");
		int id = sc.nextInt();
		sc.nextLine();
		String track = "";
		int count = 0;

		Iterator<Employee> itr = employee.iterator();
		while (itr.hasNext()) {
			Employee temp = itr.next();
			if (id == temp.getEmployee_Id()) {
				track = temp.getTrack();
				count = temp.getNumber_Of_Minds() - 1;
				itr.remove();
			}
		}

		for (Employee e : employee) {
			if (track.equalsIgnoreCase(e.getTrack())) {
				e.setNumber_Of_Minds(count);
			}
		}
		try {
			dao.deletedata(id, count, track);
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		return employee;
	}

	public List<Employee> updateMobileNumber(List<Employee> employee) {
		System.out.println("enter Employee_Id");
		int id = sc.nextInt();
		sc.nextLine();
		String currentMobilenumber = "";
		for (Employee e : employee) {
			if (id == e.getEmployee_Id()) {
				System.out.println("enter current mobilenumber");
				currentMobilenumber = sc.nextLine();
				e.setPhoneNumber(currentMobilenumber);
			}
		}
		try {
			dao.updateMobilenumber(currentMobilenumber, id);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return employee;
	}

	public void displayTracks(List<Employee> employee, String Track) {
		System.out.println("enter Track");
		String s = sc.nextLine();
		for (Employee e : employee) {
			if (s.equalsIgnoreCase(e.getTrack())) {
				if (e.getRole().equalsIgnoreCase("CampusMind")) {
					System.out.println(e);
				}
			}
		}

	}

	public void displayEmployees(List<Employee> employee) {
		for (Employee e : employee) {
			System.out.println(e);
		}
	}

	int updatecount(List<Employee> employee, String track) {

		int count = 1;
		for (Employee e : employee) {
			if (track.equalsIgnoreCase(e.getTrack())) {
				count++;
			}
		}

		for (Employee e1 : employee) {
			if (track.equalsIgnoreCase(e1.getTrack())) {
				e1.setNumber_Of_Minds(count);
			}
		}
		return count;
	}
}
