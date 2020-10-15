package com.clone.reddit.dto;

import lombok.*;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto extends BaseDto {


    private String postName;

    private String url;

    private String description;

    private Integer voteCount = 0;

    private UserDto user;

    private Instant createdDate;

    private SubredditDto subreddit;
}
