package com.atifimal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
public class TwoDatasourcePaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoDatasourcePaginationApplication.class, args);
	}

}
