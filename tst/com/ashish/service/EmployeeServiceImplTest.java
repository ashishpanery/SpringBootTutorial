package com.ashish.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashish.bean.EmployeeBean;
import com.ashish.dao.EmployeeRepository;

//@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	@Autowired
    private EmployeeService employeeService;
	
	@MockBean
    private EmployeeRepository employeeRepository;
	

    @Before
    public void setUp() {
    	employeeRepository = Mockito.mock(EmployeeRepository.class);
    	employeeService = new EmployeeService();
    }
	
	@Test
	public void getOrganizationStrucureTest() {
		
		Mockito.when(employeeRepository.getAllEmployee()).
		thenReturn(getEmployeeTestData());
		Map<Long, EmployeeBean> oranizationDetail = employeeRepository.getAllEmployee();
		assertNotNull(oranizationDetail);
		assertTrue(oranizationDetail.size()>0);
		assertEquals(1L, oranizationDetail.get(1L).getEmployeeId());
	
	}
	
	
	private static Map<Long, EmployeeBean> getEmployeeTestData(){
		Map<Long, EmployeeBean> map = new HashMap<>();
		EmployeeBean bean = getTestEmployee(1L);
		map.put(bean.getEmployeeId(),bean);
		return map;
	}

	private static EmployeeBean getTestEmployee(long employeeId) {
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeId(employeeId);
		bean.setFirstName("Name_"+employeeId);
		bean.setSecondName("secondName"+employeeId);
		bean.setCityName("City"+employeeId);
		bean.setSalary(100L);
		bean.setManagerEmployeeId(employeeId+employeeId);
		return bean;
	}
}
