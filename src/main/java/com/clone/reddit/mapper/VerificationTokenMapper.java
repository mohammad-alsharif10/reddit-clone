package com.clone.reddit.mapper;

import com.clone.reddit.dto.VerificationTokenDto;
import com.clone.reddit.model.VerificationToken;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VerificationTokenMapper extends BaseMapper<Long, VerificationTokenDto, VerificationToken> {

    @Override
    VerificationTokenDto toBaseDto(VerificationToken baseModelPram);

    @Override
    VerificationToken toBaseEntity(VerificationTokenDto baseDtoPram);

    @Override
    List<VerificationTokenDto> toBaseDtoList(List<VerificationToken> verificationTokens);

    @Override
    List<VerificationToken> toBaseEntityList(List<VerificationTokenDto> verificationTokenDtos);
}
