package com.itstep.itlibrary.repository;

import com.itstep.itlibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findAllByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);

    Optional<User> findByFirstNameOrLastName(String firstName, String lastName);

    Optional<User> findByFirstNameStartingWithOrLastNameStartingWith(String firstName, String lastName);
}
