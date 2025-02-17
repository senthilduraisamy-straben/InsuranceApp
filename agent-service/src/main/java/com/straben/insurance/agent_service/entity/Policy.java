package com.straben.insurance.agent_service.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
public class Policy {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="policy_no")
    private int policyNo;
    @Column(name="name")
    private String name;
    @Column(name="contact")
    private String contact;
    @Version
    private long version;



}
