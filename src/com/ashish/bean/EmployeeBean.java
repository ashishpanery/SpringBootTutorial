package com.ashish.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeBean {
	
	long employeeId;
	
	String firstName;
	
	String secondName;
	
	long salary;
	
	String cityName;
	
	long managerEmployeeId;
	
	List<Long> subEmpployee = new ArrayList<>();
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long long1) {
		this.employeeId = long1;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(long managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public List<Long> getSubEmpployee() {
		return subEmpployee;
	}

	public void setSubEmpployee(List<Long> subEmpployee) {
		this.subEmpployee = subEmpployee;
	}

}
