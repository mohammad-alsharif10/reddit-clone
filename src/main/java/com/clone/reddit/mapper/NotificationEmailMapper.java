package com.clone.reddit.mapper;

import com.clone.reddit.dto.NotificationEmailDto;
import com.clone.reddit.model.NotificationEmail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationEmailMapper extends BaseMapper<Long, NotificationEmailDto, NotificationEmail> {
    @Override
    NotificationEmailDto toBaseDto(NotificationEmail baseModelPram);

    @Override
    NotificationEmail toBaseEntity(NotificationEmailDto baseDtoPram);

    @Override
    List<NotificationEmailDto> toBaseDtoList(List<NotificationEmail> notificationEmails);

    @Override
    List<NotificationEmail> toBaseEntityList(List<NotificationEmailDto> notificationEmailDtos);
}
