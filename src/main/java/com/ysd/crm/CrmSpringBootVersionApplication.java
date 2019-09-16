package com.ysd.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ysd.crm.dao")
public class CrmSpringBootVersionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmSpringBootVersionApplication.class, args);
	}

}
