package com.itstep.itlibrary.service;

import com.itstep.itlibrary.dto.UserDto;
import com.itstep.itlibrary.entity.User;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.mapper.Mapper;
import com.itstep.itlibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final Mapper mapper;

    public UserDto get(Long id) {
        return userRepository.findById(id).map(mapper::toUserDto).orElseThrow(() -> new ItemNotFoundException("User not found id =" + id));
    }

    public Page<UserDto> getAll(Long id, String email, Boolean isActivated, Boolean isDisabled, Pageable pageable) {
        return userRepository.findAllBy(id, email, isActivated, isDisabled, pageable).map(mapper::toUserDto);
    }

    public void update(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("User not found id =" + id));
        mapper.mergeUser(userDto, user);
        userRepository.save(user);
    }

    public void create(UserDto userDto) {
        userRepository.save(mapper.toUser(userDto));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
