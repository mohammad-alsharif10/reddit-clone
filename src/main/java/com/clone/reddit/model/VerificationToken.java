package com.clone.reddit.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "token")
public class VerificationToken   extends  BaseModel<Long>{


    private String token;

    @OneToOne(fetch = LAZY)
    private User user;

    private Instant expiryDate;
}
