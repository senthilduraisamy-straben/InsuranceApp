package com.straben.insurance.login_service.controller;

import com.straben.insurance.login_service.client.AgentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login-service")
public class LoginServiceController {

    @Autowired
    private AgentServiceClient agentServiceClient;

    @GetMapping("/login")
    public String loginAppUser(){
        return "Welcome to login Module";
    }
    @GetMapping("/with-agent-policies")
    public ResponseEntity<?> getAgentPolicies(){
        return agentServiceClient.getPolicies();
    }
}
