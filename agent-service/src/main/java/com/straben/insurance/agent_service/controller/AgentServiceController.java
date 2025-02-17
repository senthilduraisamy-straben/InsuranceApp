package com.straben.insurance.agent_service.controller;

import com.straben.insurance.agent_service.service.AgentService;
import com.straben.insurance.agent_service.entity.Policy;
import com.straben.insurance.agent_service.util.ExcelUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agent-service")
@Slf4j
public class AgentServiceController {

    @Autowired
    AgentService agentService;


    @PostMapping("/uploadPolicies")
    public ResponseEntity<?> uploadPolicyData(@RequestParam("file")MultipartFile file){
        String message="";
        if(ExcelUtility.hasExcelFormat(file)){
            try{
                agentService.save(file);
                message = "The Excel file is uploaded: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
                //return ResponseEntity.ok(Map.of("Message","The Excel file is uploaded: " + file.getOriginalFilename()));
            } catch (Exception e) {
                log.info(e.getMessage());
                message = "The Excel file is not upload: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @GetMapping("/list-policies")
    public ResponseEntity<?> getPolicies(){
        Map<String,Object> policyRes=new LinkedHashMap<String,Object>();
        List<Policy> policyList= agentService.findAll();
        if(!policyList.isEmpty()){
            policyRes.put("Status",1);
            policyRes.put("data",policyList);
            return new ResponseEntity<>(policyRes,HttpStatus.OK);
        }else{
            policyRes.put("Status",0);
            policyRes.put("Message","Data is not found");
            return new ResponseEntity<>(policyRes,HttpStatus.NOT_FOUND);
        }
    }



}
