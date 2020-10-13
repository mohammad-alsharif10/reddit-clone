package com.clone.reddit.dto;

import com.clone.reddit.model.BaseModel;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEmailDto extends  BaseDto<Long> {
    private String subject;
    private String recipient;
    private String body;
}
