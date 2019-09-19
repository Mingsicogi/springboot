package com.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.exam.app.common.dao")
public class SecurityExamWithBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExamWithBookApplication.class, args);
	}

}
