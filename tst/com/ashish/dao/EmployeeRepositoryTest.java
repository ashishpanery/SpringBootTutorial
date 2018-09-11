package com.ashish.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EmployeeRepositoryTest {

	EmployeeDataCache employeeDataCache;
	
	EmployeeRepository repository;

	@Before
	public void setUp() {
		repository = new EmployeeRepository();
		employeeDataCache = new EmployeeDataCache();
		employeeDataCache.setFile("/home/manish/eclipse-workspace/MorganStanleyAssigment/EmployeeData.json");
		employeeDataCache.populateEmployeeCacheFromFile();
	}
	
	@Test
	public void getEmployeeById_validEmployeeId() {
		
	}
}