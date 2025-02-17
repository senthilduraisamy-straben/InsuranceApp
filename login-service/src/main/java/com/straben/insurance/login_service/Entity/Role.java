package com.straben.insurance.login_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Role {

    @Id
    @Column(name="role_id")
    private Long roleId;
    @Column(name="role_name")
    private String roleName;
    @Column(name="created_dt")
    private Date created_dt;
    @Column(name="transacted_on")
    private Date transacted_on;
    @Column(name="user_id")
    private int userId;

}
