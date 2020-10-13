package com.clone.reddit.mapper;

import com.clone.reddit.dto.RefreshTokenDto;
import com.clone.reddit.dto.VoteDto;
import com.clone.reddit.model.RefreshToken;
import com.clone.reddit.model.Vote;
import org.mapstruct.Mapper;

import javax.swing.text.rtf.RTFEditorKit;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper extends BaseMapper<Long, RefreshTokenDto, RefreshToken> {
}
