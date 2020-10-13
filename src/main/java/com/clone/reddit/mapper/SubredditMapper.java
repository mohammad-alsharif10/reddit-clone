package com.clone.reddit.mapper;

import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.model.Subreddit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PostMapper.class, UserMapper.class})
public interface SubredditMapper extends BaseMapper<Long, SubredditDto, Subreddit> {
}
