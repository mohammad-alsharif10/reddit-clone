package com.clone.reddit.mapper;

import com.clone.reddit.dto.RefreshTokenDto;
import com.clone.reddit.model.RefreshToken;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper extends BaseMapper<Long, RefreshTokenDto, RefreshToken> {

    @Override
    RefreshTokenDto toBaseDto(RefreshToken baseModelPram);

    @Override
    RefreshToken toBaseEntity(RefreshTokenDto baseDtoPram);

    @Override
    List<RefreshTokenDto> toBaseDtoList(List<RefreshToken> refreshTokens);

    @Override
    List<RefreshToken> toBaseEntityList(List<RefreshTokenDto> refreshTokenDtos);
}
