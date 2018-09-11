package com.ashish.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ashish.bean.EmployeeBean;
import com.ashish.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class EmployeeRestControllerIntegrationTest {
	
	
	@Autowired
    private WebTestClient webClient;
 
    @MockBean
    private EmployeeService service;
    
    @Before
    public void setup() {
//    	 MockitoAnnotations.initMocks(this);
//    	this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
    	Mockito.when(service.getOranizationStructure()).thenReturn(getTestEmployee(1L));
       
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
    
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
        EmployeeBean testEmp = new EmployeeBean();
        testEmp.setFirstName("Ashish");
     
//        given(service.getOranizationStructure()).willReturn(testEmp);
       
        webClient.get().uri("/printOrganizationInJSON")
        	.exchange().expectStatus().isOk();
    }
}
