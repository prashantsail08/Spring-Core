 package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JavaConfig {
	
	@Bean
	public Samosa getSamosa() {
		
		return new Samosa();
	}
	
	//whichever object we are returning that object will go to Ioc Container and we get that object from ioc container 
	@Bean //getStudent() now this will be our id
	public Student getStudent() {
		
		//creating a new student object
		Student student = new Student(getSamosa());
		
		return student;
	}

}
