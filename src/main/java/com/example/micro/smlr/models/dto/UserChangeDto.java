package com.example.micro.smlr.models.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class UserChangeDto {
    private Long userId;
    private String username;
    private Integer age;
}
