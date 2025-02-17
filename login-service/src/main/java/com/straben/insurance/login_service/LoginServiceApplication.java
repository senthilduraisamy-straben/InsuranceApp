package com.straben.insurance.login_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@EnableDiscoveryClient
@ComponentScan({"com.straben.insurance.login_service.controller",
		"com.straben.insurance.login_service.entity",
		"com.straben.insurance.login_service.repository",
		"com.straben.insurance.login_service.service",
		"com.straben.insurance.login_service.client",
		"com.straben.insurance.login_service.config"})
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

}
