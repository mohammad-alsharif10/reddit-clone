package com.clone.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDto extends BaseDto implements Serializable {

    private String name;

    private String description;

    private List<PostDto> posts;

    private Instant createdDate;

    private UserDto user;
}
