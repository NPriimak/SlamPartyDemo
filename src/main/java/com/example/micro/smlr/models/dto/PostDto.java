package com.example.micro.smlr.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class PostDto {
    private Long postId;
    private String header;
    private String body;
    private Long ownerId;

}
