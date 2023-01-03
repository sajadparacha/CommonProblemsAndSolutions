package com.knowledge.sharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

//@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@SpringBootApplication
public class CommonProblemsAndSolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonProblemsAndSolutionsApplication.class, args);
	}

}
