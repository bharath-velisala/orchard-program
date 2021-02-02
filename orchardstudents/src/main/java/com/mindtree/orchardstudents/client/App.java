package com.mindtree.orchardstudents.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.orchardstudents.daoLayer.daoLayer;
import com.mindtree.orchardstudents.daoLayer.daoLayerImpl.DaoImpl;
import com.mindtree.orchardstudents.entity.Employee;
import com.mindtree.orchardstudents.service.serviceImpl.serviceImpl;

public class App extends serviceImpl {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		App  app=new App();
		List<Employee>employee=new ArrayList<Employee>();
		employee=app.previousdata(employee);
		boolean flag=true;
		do {
			System.out.println("press 1 to adddetails");
			System.out.println("press 2 to delete employee");
			System.out.println("press 3 to update mobile number");
			System.out.println("press 4 to display details");
			System.out.println("press 5 to exit");
			int a=sc.nextInt();
			switch(a) {
			case 1:
				app.addEmployee(employee);
				break;
			case 2:
				app.deleteEmployee(employee);
				break;
			case 3:
				app.updateMobileNumber(employee);
				break;
			case 4:
				app.displayEmployees(employee);
				break;
			case 5 :
				flag=false;
				break;
			}
		}while(flag!=false);
	}
}
