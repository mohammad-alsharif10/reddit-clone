package com.clone.reddit.dto;

import com.clone.reddit.model.BaseModel;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto extends BaseDto<Long> {


    private String postName;

    private String url;

    private String description;

    private Integer voteCount = 0;

    private UserDto user;

    private Instant createdDate;

    private SubredditDto subreddit;
}
