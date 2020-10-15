package com.clone.reddit.mapper;

import com.clone.reddit.dto.PostDto;
import com.clone.reddit.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, SubredditMapper.class})
public interface PostMapper extends BaseMapper<Long, PostDto, Post> {

    @Override
    @Mappings({
            @Mapping(target = "subreddit", ignore = true),
    })
    PostDto toBaseDto(Post baseModelPram);

    @Override
    Post toBaseEntity(PostDto baseDtoPram);

    @Override
    List<PostDto> toBaseDtoList(List<Post> posts);

    @Override
    List<Post> toBaseEntityList(List<PostDto> postDtos);
}
