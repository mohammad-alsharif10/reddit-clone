package com.clone.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto extends BaseDto<Long> {

    private String text;

    private PostDto post;

    private Instant createdDate;

    private UserDto user;
}
