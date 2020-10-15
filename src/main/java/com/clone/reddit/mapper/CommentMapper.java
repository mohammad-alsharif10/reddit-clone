package com.clone.reddit.mapper;

import com.clone.reddit.dto.CommentDto;
import com.clone.reddit.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class, UserMapper.class})
public interface CommentMapper extends BaseMapper<Long, CommentDto, Comment> {

    @Override
    CommentDto toBaseDto(Comment baseModelPram);

    @Override
    Comment toBaseEntity(CommentDto baseDtoPram);

    @Override
    List<CommentDto> toBaseDtoList(List<Comment> comments);

    @Override
    List<Comment> toBaseEntityList(List<CommentDto> commentDtos);
}
