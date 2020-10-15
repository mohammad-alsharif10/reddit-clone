package com.clone.reddit.mapper;

import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.model.Subreddit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class, UserMapper.class})
public interface SubredditMapper extends BaseMapper<Long, SubredditDto, Subreddit> {


    SubredditDto toBaseDto(Subreddit baseModelPram);


    Subreddit toBaseEntity(SubredditDto baseDtoPram);


    List<SubredditDto> toBaseDtoList(List<Subreddit> subreddits);


    List<Subreddit> toBaseEntityList(List<SubredditDto> subredditDtoList);
}
