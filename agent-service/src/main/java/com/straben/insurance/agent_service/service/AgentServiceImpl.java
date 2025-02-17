package com.straben.insurance.agent_service.service;

import com.straben.insurance.agent_service.repository.AgentServiceRepository;
import com.straben.insurance.agent_service.entity.Policy;
import com.straben.insurance.agent_service.util.ExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

@Autowired
AgentServiceRepository agentServiceRepository;


    public void save(MultipartFile file) {
        try{
            List<Policy> policies= ExcelUtility.getPolicyDataFromExcel(file.getInputStream());
            this.agentServiceRepository.saveAll(policies);
        } catch (IOException e) {
            throw new RuntimeException("Excel data is failed to store: " + e.getMessage());
        }

    }


    public List<Policy> findAll() {
        return agentServiceRepository.findAll();
    }
}
