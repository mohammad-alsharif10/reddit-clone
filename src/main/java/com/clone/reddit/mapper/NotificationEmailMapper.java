package com.clone.reddit.mapper;

import com.clone.reddit.dto.NotificationEmailDto;
import com.clone.reddit.dto.VoteDto;
import com.clone.reddit.model.NotificationEmail;
import com.clone.reddit.model.Vote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationEmailMapper  extends BaseMapper<Long, NotificationEmailDto, NotificationEmail>{
}
