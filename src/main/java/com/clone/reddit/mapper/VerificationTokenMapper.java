package com.clone.reddit.mapper;

import com.clone.reddit.dto.VerificationTokenDto;
import com.clone.reddit.model.VerificationToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VerificationTokenMapper extends BaseMapper<Long, VerificationTokenDto, VerificationToken> {
}
