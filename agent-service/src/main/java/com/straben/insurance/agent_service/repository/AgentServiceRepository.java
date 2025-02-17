package com.straben.insurance.agent_service.repository;

import com.straben.insurance.agent_service.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentServiceRepository extends JpaRepository<Policy,Integer> {

}
