package com.clone.reddit.mapper;

import com.clone.reddit.dto.BaseDto;
import com.clone.reddit.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<ID extends Serializable, baseDto extends BaseDto, baseModel extends BaseModel<ID>> {

    baseDto toBaseDto(baseModel baseModelPram);

    baseModel toBaseEntity(baseDto baseDtoPram);

    List<baseDto> toBaseDtoList(List<baseModel> baseModelList);

    List<baseModel> toBaseEntityList(List<baseDto> baseDtoList);

}
