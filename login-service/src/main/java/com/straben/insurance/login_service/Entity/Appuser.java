package com.straben.insurance.login_service.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Table(name="app_user")
@Setter
@Getter
public class Appuser {

    @Id
    @Column(name="user_id")
    private Long userId;

    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @Column(name="created_dt")
    private Date  CreatedDate;
    @Column(name="end_dt")
    private Date  endDate;
    @Column(name="transacted_on")
    private Date transactedOn;

}
