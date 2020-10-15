package com.clone.reddit.mapper;

import com.clone.reddit.dto.VoteDto;
import com.clone.reddit.model.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PostMapper.class})
public interface VoteMapper extends BaseMapper<Long, VoteDto, Vote> {

    @Override
    @Mappings({
            @Mapping(target = "post", ignore = true),
    })
    VoteDto toBaseDto(Vote baseModelPram);


    Vote toBaseEntity(VoteDto baseDtoPram);


    List<VoteDto> toBaseDtoList(List<Vote> votes);


    List<Vote> toBaseEntityList(List<VoteDto> voteDtos);
}
