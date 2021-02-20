package com.example.micro.smlr.services.entity;

import com.example.micro.smlr.models.entity.Role;
import com.example.micro.smlr.repos.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
