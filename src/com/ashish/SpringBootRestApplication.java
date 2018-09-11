package com.ashish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ashish.dao.EmployeeDataCache;

@SpringBootApplication(scanBasePackages= {"com.ashish"})
public class SpringBootRestApplication {
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SpringBootRestApplication.class, args);
		EmployeeDataCache employeeDataCache = (EmployeeDataCache) appContext.getBean("EmployeeCache");
		employeeDataCache.populateEmployeeCacheFromFile();
	}
}
