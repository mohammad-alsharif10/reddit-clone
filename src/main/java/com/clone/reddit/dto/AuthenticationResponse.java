package com.clone.reddit.dto;

import lombok.*;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationResponse extends BaseDto {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
}
