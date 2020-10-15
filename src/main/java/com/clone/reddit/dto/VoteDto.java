package com.clone.reddit.dto;

import com.clone.reddit.model.VoteType;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteDto extends BaseDto {


    private VoteType voteType;

    private PostDto post;

    private UserDto user;
}
