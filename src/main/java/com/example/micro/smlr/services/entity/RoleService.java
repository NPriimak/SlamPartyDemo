package com.example.micro.smlr.services.entity;

import com.example.micro.smlr.models.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByName(String name);
}
