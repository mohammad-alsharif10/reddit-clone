package com.clone.reddit.dto;

import lombok.*;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends BaseDto {


    private String username;

    private String password;


    private String email;

    private Instant created;

    private boolean enabled;
}
