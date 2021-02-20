package com.example.micro.smlr.models.dto;

import com.example.micro.smlr.models.entity.User;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class RoleDto {

    private String name;
}
