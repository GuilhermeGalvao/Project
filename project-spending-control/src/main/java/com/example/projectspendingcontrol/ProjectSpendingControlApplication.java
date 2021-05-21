package com.example.projectspendingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableSpringDataWebSupport
public class ProjectSpendingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSpendingControlApplication.class, args);
	}

}
