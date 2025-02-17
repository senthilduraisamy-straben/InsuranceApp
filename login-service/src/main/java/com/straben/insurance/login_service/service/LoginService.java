package com.straben.insurance.login_service.service;

import com.straben.insurance.login_service.Entity.Appuser;
import com.straben.insurance.login_service.repository.LoginServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginServiceRepository loginServiceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Appuser appuser=loginServiceRepository.findByUserName(username);
        if(appuser==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new LoginAppUserDetails(appuser);
    }
}
