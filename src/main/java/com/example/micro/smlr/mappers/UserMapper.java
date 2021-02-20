package com.example.micro.smlr.mappers;

import com.example.micro.smlr.models.dto.NewUserDto;
import com.example.micro.smlr.models.dto.UserChangeDto;
import com.example.micro.smlr.models.dto.UserDto;
import com.example.micro.smlr.models.entity.Role;
import com.example.micro.smlr.models.entity.User;
import com.example.micro.smlr.services.entity.RoleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Service
public abstract class UserMapper {

    protected  PasswordEncoder passwordEncoder;
    protected  RoleService roleService;

    @Autowired
    protected void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    protected void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }



    @Mappings({
            @Mapping(target = "roleName", source = "role.name")
    })
    public abstract UserDto toUserDto (User user);

    @Mappings({
            @Mapping(target = "role", source = "roleName", qualifiedByName = "roleSetter"),
    })
    public abstract User toEntity (UserDto userDto);

    public abstract User toEntity (UserChangeDto userChangeDto);

    @Mappings({
            @Mapping(target = "role", source = "roleName", qualifiedByName = "roleSetter"),
            @Mapping(target = "password", source = "password", qualifiedByName = "passwordSetter")
    })
    public abstract User toEntity (NewUserDto newUser);



    @Named("roleSetter")
    protected Role roleSetter(String roleName){
        if (roleName == null){
            return roleService.findRoleByName("USER").get();
        }

        Optional<Role> userRole =  roleService.findRoleByName(roleName);
        if (userRole.isEmpty()){
            throw new EntityNotFoundException("Role not found");
        }
        return userRole.get();
    }

    @Named("passwordSetter")
    protected String passwordSetter(String password){
        return passwordEncoder.encode(password);
    }
}
