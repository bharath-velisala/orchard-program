package com.mindtree.orchardstudents.daoLayer;

import java.util.List;

import com.mindtree.orchardstudents.entity.Employee;

public interface daoLayer {
	//daolayer methods
	void addData(int id,String name,String track,int count,String mobilenumber,String role)throws DaoException ;
	void countupdatesql(int count,String role)throws DaoException;
	void deletedata(int id,int count,String track)throws DaoException;
	void updateMobilenumber(String phonenumber,int id)throws DaoException;
	List<Employee> previousdata(List<Employee>employee)throws DaoException;
	
}
