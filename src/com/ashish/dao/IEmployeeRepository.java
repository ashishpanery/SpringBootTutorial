package com.ashish.dao;

import java.util.List;
import java.util.Map;

import com.ashish.bean.EmployeeBean;

public interface IEmployeeRepository {

	public EmployeeBean getEmployeeById(long employeeId);
	
	public List<EmployeeBean> getListOfSubOrdinate(long employeeId);
	
	public  Map<Long, EmployeeBean> getAllEmployee();
	
	public EmployeeBean getEmployeeTree();
	
	public void refreshEmployeeCache();
	
}
