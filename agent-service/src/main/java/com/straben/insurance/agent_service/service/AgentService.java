package com.straben.insurance.agent_service.service;

import com.straben.insurance.agent_service.entity.Policy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AgentService {
    void save(MultipartFile file);
    List<Policy> findAll();
}
