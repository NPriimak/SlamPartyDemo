package com.example.micro.smlr.repos;

import com.example.micro.smlr.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String name);
    Optional<User> findUserById(Long id);
    }
