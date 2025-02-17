package com.straben.insurance.login_service.repository;

import com.straben.insurance.login_service.Entity.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginServiceRepository extends JpaRepository<Appuser,Long> {

    Appuser findByUserName(String userName);

}
