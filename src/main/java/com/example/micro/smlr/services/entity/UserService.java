package com.example.micro.smlr.services.entity;

import com.example.micro.smlr.models.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    Boolean changeUser(User user);
    Boolean save(User user);
}
