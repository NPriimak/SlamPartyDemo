package com.example.micro.smlr.models.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class NewUserDto {
    private String username;
    private String password;
    private Integer age;
    private String roleName;
}
