package com.itstep.itlibrary.service;

import com.itstep.itlibrary.entity.User;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("User not found id=" + id));
    }

    public List<User> getAll() {
        return  userRepository.findAll();
    }

    public void update(Long id, User userUpdate) {
        User user = get(id);
        user.setEmail(userUpdate.getEmail());
        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        userRepository.save(user);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
