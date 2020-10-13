package com.clone.reddit.dto;

import com.clone.reddit.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "token")
public class VerificationTokenDto extends BaseDto<Long> {


    private String token;

    private UserDto user;

    private Instant expiryDate;
}
