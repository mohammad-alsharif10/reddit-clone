package com.clone.reddit.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEmailDto extends BaseDto {
    private String subject;
    private String recipient;
    private String body;
}
