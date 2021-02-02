package com.mindtree.orchardstudents.entity;

public class Employee {
	private int employee_Id;
	private String employee_Name;
	private String track;
	private int number_Of_Minds;
	private String PhoneNumber;
	private String role;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int employee_Id, String employee_Name, String track, int number_Of_Minds, String phoneNumber,
			String role) {
		super();
		this.employee_Id = employee_Id;
		this.employee_Name = employee_Name;
		this.track = track;
		this.number_Of_Minds = number_Of_Minds;
		PhoneNumber = phoneNumber;
		this.role = role;
	}


	public int getEmployee_Id() {
		return employee_Id;
	}


	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}


	public String getEmployee_Name() {
		return employee_Name;
	}


	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}


	public String getTrack() {
		return track;
	}


	public void setTrack(String track) {
		this.track = track;
	}


	public int getNumber_Of_Minds() {
		return number_Of_Minds;
	}


	public void setNumber_Of_Minds(int number_Of_Minds) {
		this.number_Of_Minds = number_Of_Minds;
	}


	public String getPhoneNumber() {
		return PhoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", track=" + track
				+ ", number_Of_Minds=" + number_Of_Minds + ", PhoneNumber=" + PhoneNumber + ", role=" + role + "]";
	}
	
	
	
}
