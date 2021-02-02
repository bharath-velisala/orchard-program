package com.mindtree.orchardstudents.service;

import java.util.List;

import com.mindtree.orchardstudents.entity.Employee;

public interface serviceInterface {
 public List<Employee>addEmployee(List<Employee>employee) throws Exception;
 public List<Employee>deleteEmployee(List<Employee>employee)throws Exception;
 public List<Employee>updateMobileNumber(List<Employee>employee)throws Exception;
 public void displayTracks(List<Employee>employee,String Track)throws Exception;
 
}
