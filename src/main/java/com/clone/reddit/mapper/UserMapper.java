package com.clone.reddit.mapper;

import com.clone.reddit.dto.UserDto;
import com.clone.reddit.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<Long, UserDto, User> {
}
