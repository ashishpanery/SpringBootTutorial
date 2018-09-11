package com.ashish.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.ashish.bean.EmployeeBean;

@Repository("EmployeeCache")
public class EmployeeDataCache {

	private static String fileName = "/home/manish/eclipse-workspace/MorganStanleyAssigment/EmployeeData.json";
	
	private Map<Long,EmployeeBean> employeeCache;
	
	private EmployeeBean organizationRoot;
	
	public Map<Long, EmployeeBean> getEmployeeCacheInstance(){
		return employeeCache;
	}
	
	public void populateEmployeeCacheFromFile() {
		employeeCache = new HashMap<Long,EmployeeBean>();
		List<EmployeeBean> employees = getEmployeeDataFromFile();
		employees.forEach(emp->{
			employeeCache.put(emp.getEmployeeId(), emp);
			System.out.println("employee:"+emp.getFirstName()+", key="+emp.getEmployeeId());
		});
		
		employeeCache.keySet().forEach(empId -> {
			EmployeeBean employee = employeeCache.get(empId);
			long managerId = employee.getManagerEmployeeId();
			EmployeeBean manager = employeeCache.get(managerId);
			if(manager != null) {
				manager.getSubEmpployee().add(empId);
			}else if(managerId == 0){
				organizationRoot = employee;
			}
		});
		System.out.println(employeeCache);
	}
	
	public EmployeeBean getOrganizationTreeNode() {
		return organizationRoot;
	}
	@SuppressWarnings("unchecked")
	public List<EmployeeBean> getEmployeeDataFromFile(){
		List<EmployeeBean> employees = new ArrayList<>();
		 JSONParser jsonParser = new JSONParser();
         
	        try (FileReader reader = new FileReader(fileName))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray employeeList = (JSONArray) obj;
	            System.out.println(employeeList);
	            
	            employeeList.forEach(empObject -> {
	            	employees.add(parseEmployeeJSONObject((JSONObject) empObject));
	            });
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		
		return employees;
	}
	
	public EmployeeBean parseEmployeeJSONObject(JSONObject empObject) {
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeId((Long) empObject.get("Employee ID"));
		bean.setFirstName((String) empObject.get("First Name"));
		bean.setSecondName((String) empObject.get("Second Name"));
		bean.setManagerEmployeeId((Long) empObject.get("Manager Emp Id"));
		bean.setSalary((long) empObject.get("Salary"));
		bean.setCityName((String) empObject.get("City Name"));
		return bean;
		
		
	}
	public static void main(String[] args) {
		EmployeeDataCache cache = new EmployeeDataCache();
		cache.populateEmployeeCacheFromFile();
		cache.getEmployeeCacheInstance().keySet().forEach(id->{
			
			System.out.println("id="+id+", check="+(id==1490));
			
		});
		System.out.println(cache.getEmployeeCacheInstance().get(1490L));
		System.out.println(cache.getEmployeeCacheInstance().get(1490L).getSubEmpployee());
	}
	
	public void setFile(String fileName) {
		this.fileName = fileName;
	}
}
