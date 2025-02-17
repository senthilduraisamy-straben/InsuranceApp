package com.straben.insurance.agent_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.straben.insurance.agent_service.controller",
				"com.straben.insurance.agent_service.entity",
				"com.straben.insurance.agent_service.repository",
				"com.straben.insurance.agent_service.service",
				"com.straben.insurance.agent_service.util"})
@EnableJpaRepositories
public class AgentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentServiceApplication.class, args);
	}

}
