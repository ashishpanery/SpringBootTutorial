package com.ashish.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.bean.EmployeeBean;
import com.ashish.dao.EmployeeRepository;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public EmployeeBean getOranizationStructure() {
		EmployeeBean root = employeeRepository.getEmployeeTree();
		return root;
	}

	@Override
	public EmployeeBean getEmployeeBeanById(long employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}

	@Override
	public void refreshEmployeeCache() {
		employeeRepository.refreshEmployeeCache();
		
	}

	@Override
	public String changeManagerForEmployee(long employeeId, long managerId) {

		EmployeeBean empBean = getEmployeeBeanById(employeeId);
		if(empBean == null)
			return "No Employee Found with This Id";
		
		EmployeeBean newManager = getEmployeeBeanById(managerId);
		if(newManager == null)
			return "No Manager present with given Id";
		
		long oldManagerId = empBean.getManagerEmployeeId();
		EmployeeBean oldManagerBean = getEmployeeBeanById(oldManagerId);
		if(oldManagerBean != null) {
			List<Long> subOrdinate = oldManagerBean.getSubEmpployee();
			int i=0;
			for(i=0; i< subOrdinate.size(); i++) {
				if(subOrdinate.get(i) == employeeId) {
					subOrdinate.remove(i);
					break;
				}
			}
		}
		empBean.setManagerEmployeeId(managerId); 
		newManager.getSubEmpployee().add(employeeId);
		return "Success";
		
	}

	@Override
	public EmployeeBean getMaxSubOrdinateEmployee() {

		EmployeeBean root = employeeRepository.getEmployeeTree();
		EmployeeBean resultNode = root;
		int maxCount = root.getSubEmpployee().size();
		Queue<EmployeeBean> level = new LinkedList<>();
		level.add(root);
		while (!level.isEmpty()) {
			EmployeeBean node = level.poll();
			if (node.getSubEmpployee() != null) {
				if(maxCount<node.getSubEmpployee().size()) {
					maxCount = node.getSubEmpployee().size();
					resultNode = node;
				}
				node.getSubEmpployee().forEach(id -> level.add(getEmployeeBeanById(id)));
			}
		}
		return resultNode;
	}

	@Override
	public long getTotalSalaryForEmployeeSubOrdinate(long employeeId) {
		long salary = 0;
		EmployeeBean employeeBean = getEmployeeBeanById(employeeId);
		for (int i = 0; i < employeeBean.getSubEmpployee().size(); i++) {
			long empId = employeeBean.getSubEmpployee().get(i);
			salary += getEmployeeBeanById(empId).getSalary();
		}
		return salary;
	}

	@Override
	public EmployeeBean getCommonManager(long empId1, long empId2) {
		
		EmployeeBean employeeBean1 = getEmployeeBeanById(empId1);
		EmployeeBean employeeBean2 = getEmployeeBeanById(empId2);
		
		if(empId1 == empId2)
			return employeeBean1;
		
		
		if(employeeBean2 == null || employeeBean1.getSubEmpployee().contains(empId2)) {
			return employeeBean1;
		}
		if(employeeBean1 == null || employeeBean2.getSubEmpployee().contains(empId1)) { 
			return employeeBean2;
		}
		return getCommonAncentorInOrganizationTree(employeeBean1, employeeBean2);
	}
	
	public EmployeeBean getCommonAncentorInOrganizationTree(EmployeeBean employeeBean1, EmployeeBean employeeBean2) {
		
		if(employeeBean1.getManagerEmployeeId() == employeeBean2.getManagerEmployeeId())
			return getEmployeeBeanById(employeeBean1.getManagerEmployeeId());
		
		return getCommonManager(employeeBean1.getManagerEmployeeId(), employeeBean2.getManagerEmployeeId());
		
	}

	
}
