package com.morxz.eco_trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc // enable web mvc conf
public class EcoTraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoTraceApplication.class, args);
	}

}
