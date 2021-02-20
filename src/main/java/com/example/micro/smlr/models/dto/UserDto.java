package com.example.micro.smlr.models.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UserDto {
    private Long userId;
    private String username;
    private Integer age;
    private String roleName;

}
