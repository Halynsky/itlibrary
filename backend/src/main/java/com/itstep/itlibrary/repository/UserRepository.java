package com.itstep.itlibrary.repository;

import com.itstep.itlibrary.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);
    Optional<User> findByFirstNameOrLastName(String firstName, String lastName);
    Optional<User> findByFirstNameStartingWithOrLastNameStartingWith(String firstName, String lastName);

    @Query("""
        SELECT u FROM User u
        WHERE (:id IS NULL OR u.id = :id)
        AND (:email IS NULL OR lower(u.email) LIKE concat('%', lower(:email), '%'))
        AND (:isActivated IS NULL OR u.isActivated = :isActivated)
        AND (:isDisabled IS NULL OR u.isDisabled = :isDisabled)
    """)
    Page<User> findAllBy(Long id, String email, Boolean isActivated, Boolean isDisabled, Pageable pageable);
}
