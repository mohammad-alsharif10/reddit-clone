package com.clone.reddit.dto;

import com.clone.reddit.model.BaseModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDto extends  BaseDto<Long>{


    private String name;

    private String description;

    private List<PostDto> posts;

    private Instant createdDate;

    private UserDto user;
}
