package com.straben.insurance.login_service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface AgentServiceClient {

    @GetExchange("agent-service/list-policies")
    public ResponseEntity<?> getPolicies();
}
