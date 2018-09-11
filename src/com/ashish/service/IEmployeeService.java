package com.ashish.service;

import com.ashish.bean.EmployeeBean;

public interface IEmployeeService {

	public EmployeeBean getOranizationStructure();
	
	public EmployeeBean getEmployeeBeanById(long employeeId);
	
	public void refreshEmployeeCache();
	
	public String changeManagerForEmployee(long employeeId, long managerId);
	
	public EmployeeBean getMaxSubOrdinateEmployee();
	
	public long getTotalSalaryForEmployeeSubOrdinate(long employeeId);
	
	public EmployeeBean getCommonManager(long empId1, long empId2);
}
