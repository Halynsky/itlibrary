package com.itstep.itlibrary.security;

import com.itstep.itlibrary.entity.User;
import com.itstep.itlibrary.exception.AccountIsNotActivatedException;
import com.itstep.itlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUserService implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        if (!user.getIsActivated()) throw new AccountIsNotActivatedException();

        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .disabled(user.getIsDisabled())
                .roles(user.getRole().toString())
                .build();
    }
}
