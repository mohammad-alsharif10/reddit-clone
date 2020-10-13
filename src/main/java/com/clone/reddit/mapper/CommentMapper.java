package com.clone.reddit.mapper;

import com.clone.reddit.dto.CommentDto;
import com.clone.reddit.dto.VoteDto;
import com.clone.reddit.model.Comment;
import com.clone.reddit.model.Vote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PostMapper.class, UserMapper.class})
public interface CommentMapper  extends BaseMapper<Long, CommentDto, Comment>{
}
