package com.ashish.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashish.bean.EmployeeBean;
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockRestServiceServer
public class RandomPortTestRestTemplateExampleTests {

	@Autowired
	private TestRestTemplate restTemplate;
	

	@Test
	public void exampleTest() {
		ResponseEntity<EmployeeBean> bean = this.restTemplate.getForEntity("/getmaxsubordinate", EmployeeBean.class);
//		String body = this.restTemplate.getForObject("/getmaxsubordinate");
//		assertThat(body).doesNotContain("Error");
	}
	
	@Test
	public void exampleTest2() {
		String body = this.restTemplate.getForObject("/printOrganizationInJSON", String.class);
		assertThat(body).doesNotContain("Error");
	}
}

