package com.mcode.alumninetwork3i.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    @Size(max = 4096)
    private String content;
}