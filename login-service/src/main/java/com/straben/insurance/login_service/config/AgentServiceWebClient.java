package com.straben.insurance.login_service.config;

import com.straben.insurance.login_service.client.AgentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AgentServiceWebClient {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient agentWebClient(){
        return WebClient.builder().
                baseUrl("http://agent-service").
                filter(filterFunction).build();
    }

    @Bean
    public AgentServiceClient agentServiceClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(agentWebClient())).build();
               return httpServiceProxyFactory.createClient(AgentServiceClient.class);
    }

}
