package com.clone.reddit.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEmail  extends  BaseModel<Long>{
    private String subject;
    private String recipient;
    private String body;
}
