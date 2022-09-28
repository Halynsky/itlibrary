package com.itstep.itlibrary.security;

import com.itstep.itlibrary.entity.User;
import com.itstep.itlibrary.exception.AuthenticationRequiredException;
import com.itstep.itlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    @Autowired UserRepository userRepository;

    public User getUser() {
        return this.userRepository.findByEmail(getCurrentUserEmail()).orElseThrow(AuthenticationRequiredException::new);
    }

    public String getCurrentUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
