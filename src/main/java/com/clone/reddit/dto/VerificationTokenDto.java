package com.clone.reddit.dto;

import lombok.*;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationTokenDto extends BaseDto {


    private String token;

    private UserDto user;

    private Instant expiryDate;
}
