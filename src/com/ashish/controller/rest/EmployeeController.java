package com.ashish.controller.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.bean.EmployeeBean;
import com.ashish.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value="/printOrganization", method= RequestMethod.GET)
	public String printOrganizationStructure(){

		EmployeeBean root = employeeService.getOranizationStructure();
		StringBuffer sb = new StringBuffer();
		convertObjectsInString(root, sb);
		return sb.toString();
		
	}
	
	@RequestMapping(value="/printOrganizationInJSON", method= RequestMethod.GET)
	public JSONObject printOrganizationStructureInJSON(){
		EmployeeBean root = employeeService.getOranizationStructure();
		JSONObject object = getSubEmployeeAsJSONModel(root.getEmployeeId());
		return object;
		
	}
	
	@RequestMapping(value="/changeManager", method = RequestMethod.POST)
	public String changeManager(@RequestParam long employeeId, @RequestParam long managerId) {
		return employeeService.changeManagerForEmployee(employeeId, managerId);
		
	}
	
	@RequestMapping(value="/getmaxsubordinate", method=RequestMethod.GET)
	public EmployeeBean getMaxSubOrdinateEmployee() {
		return employeeService.getMaxSubOrdinateEmployee();
		
	}
	
	@RequestMapping(value="/computesalaryforsubordinary", method=RequestMethod.GET)
	public long getMaxSalaryForEmployee(@RequestParam long employeeId) {
		return employeeService.getTotalSalaryForEmployeeSubOrdinate(employeeId);
		
	}
	
	@RequestMapping(value="/findCommonManager", method=RequestMethod.GET)
	public EmployeeBean getMaxSalaryForEmployee(@RequestParam long employeeId1, @RequestParam long employeeId2) {
		EmployeeBean bean =  employeeService.getCommonManager(employeeId1, employeeId2);
		if(bean == null) {
			return new EmployeeBean();
		}
		return bean;
	}
	
	private void convertObjectsInString(EmployeeBean root, StringBuffer sb) {
		
		     Queue<EmployeeBean> level  = new LinkedList<>();
		     level.add(root);
		     System.out.println(root.getSubEmpployee());
		     while(!level.isEmpty()){
		    	 EmployeeBean node = level.poll();
		         System.out.print(node.getFirstName() + " ");
		         sb.append(node.getFirstName() + " ");
		         sb.append("<br>");
		         if(node.getSubEmpployee() != null) {
		        	 node.getSubEmpployee().forEach(id->level.add(employeeService.getEmployeeBeanById(id)));
		         }
		     }
		
	}
	
	@RequestMapping(value="/refreshEmployeeCache", method= RequestMethod.GET)
	public String refreshEmployeeCache(){

		employeeService.refreshEmployeeCache();
		return "sucess";
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject convertEmployeeObjectInJSON(EmployeeBean bean) {
		JSONObject object = new JSONObject();
		object.put("Employee ID", bean.getEmployeeId());
		object.put("First Name", bean.getFirstName());
		object.put("Second Name", bean.getSecondName());
		object.put("Manager Emp Id", bean.getManagerEmployeeId());
		object.put("Salary", bean.getSalary());
		object.put("City Name", bean.getCityName());
		return object;
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject getSubEmployeeAsJSONModel(Long empId) {
		
		EmployeeBean bean = employeeService.getEmployeeBeanById(empId);
		JSONObject object = convertEmployeeObjectInJSON(bean);
		if(bean.getSubEmpployee() != null) {
		 List<Long> empIds = bean.getSubEmpployee();
		 JSONArray arr = new JSONArray();
		 empIds.forEach(subEmpId->{
			 arr.add(getSubEmployeeAsJSONModel(subEmpId));
		 });
		 object.put("subOrdinate", arr);
		}
		
		return object;
	}
	
}
