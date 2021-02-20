package com.example.micro.smlr.mappers;

import com.example.micro.smlr.models.dto.RoleDto;
import com.example.micro.smlr.models.entity.Role;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {
    @Mappings({
            @Mapping(target = "name", source = "name")
    })
    public abstract RoleDto roleToRoleDto(Role role);

    public abstract Role RoleDtoToEntity (RoleDto roleDto);
}
