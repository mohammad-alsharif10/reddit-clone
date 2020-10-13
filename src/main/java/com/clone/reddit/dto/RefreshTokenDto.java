package com.clone.reddit.dto;

import com.clone.reddit.model.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshTokenDto extends  BaseDto<Long> {

    private String token;
    private Instant createdDate;
}
