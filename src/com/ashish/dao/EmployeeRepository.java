package com.ashish.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashish.bean.EmployeeBean;

@Repository
public class EmployeeRepository implements IEmployeeRepository {


	@Autowired
	EmployeeDataCache employeeDataCache;

	@Override
	public EmployeeBean getEmployeeById(long employeeId) {
		return employeeDataCache.getEmployeeCacheInstance().get(employeeId);
	}

	@Override
	public List<EmployeeBean> getListOfSubOrdinate(long employeeId) {
		List<EmployeeBean> subOrdinateList = new ArrayList<>();
		employeeDataCache.
			getEmployeeCacheInstance().
			get(employeeId).
			getSubEmpployee().
			forEach(empId->{
				subOrdinateList.add(getEmployeeById(empId));
			});
		return subOrdinateList;
		
	}

	@Override
	public Map<Long, EmployeeBean> getAllEmployee() {
		return employeeDataCache.getEmployeeCacheInstance();
	}

	@Override
	public EmployeeBean getEmployeeTree() {
		
		return employeeDataCache.getOrganizationTreeNode();
	}
	
	public int addEmployeeInManager(long employeeId, long managerId) {
		EmployeeBean emp = employeeDataCache.getEmployeeCacheInstance().get(managerId);
		if(emp != null) {
			emp.getSubEmpployee().add(employeeId);
			return 200;
		}else {
			return 404;
		}
	}
	
	public int removeEmployeeFromManager(long employeeId, long managerId) {
		EmployeeBean emp = employeeDataCache.getEmployeeCacheInstance().get(managerId);
		if(emp != null) {
			emp.getSubEmpployee().remove(employeeId);
			return 200;
		}else {
			return 404;
		}
	}

	@Override
	public void refreshEmployeeCache() {
		
		employeeDataCache.populateEmployeeCacheFromFile();
	}

}
