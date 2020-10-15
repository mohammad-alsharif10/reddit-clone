package com.clone.reddit.service;


import com.clone.reddit.database.SubredditRepository;
import com.clone.reddit.database.UserRepository;
import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.exception.SpringRedditException;
import com.clone.reddit.mapper.SubredditMapper;
import com.clone.reddit.mapper.UserMapper;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.respnse.ListResponse;
import com.clone.reddit.respnse.SingleResultResponse;
import com.clone.reddit.utils.Common;
import com.clone.reddit.utils.ResponseKeys;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public SingleResultResponse save(SubredditDto subredditDto) {
        Subreddit subreddit = subredditMapper.toBaseEntity(subredditDto);
        subreddit.setUser(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null));
        Subreddit save = subredditRepository.save(subreddit);
        subredditDto = subredditMapper.toBaseDto(save);
        subredditDto.setId(save.getId());
        return Common.getSingleResultDto(subredditDto,
                ResponseKeys.REGISTERED_SUCCESSFULLY
                , false, ResponseKeys.SUCCESS_RESPONSE);
    }

    @SneakyThrows
    public SingleResultResponse getById(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return Common.getSingleResultDto(subredditMapper.toBaseDto(subreddit),
                ResponseKeys.FOUND_IT
                , false, ResponseKeys.SUCCESS_RESPONSE);
    }


    public ListResponse getSubredditPage(Integer pageNumber, Integer size) {
        Page<Subreddit> subredditPage = subredditRepository.findAll(PageRequest.of(pageNumber, size));
//        return Common.getListResponse(subredditDtoPage, ResponseKeys.FOUND_IT, false, ResponseKeys.SUCCESS_RESPONSE);
        List<SubredditDto> subredditDtoList = subredditMapper.toBaseDtoList(subredditPage.get().collect(Collectors.toList()));
        return new ListResponse(Collections.singletonList(subredditDtoList)
                , subredditPage.getTotalElements()
                , subredditPage.getTotalPages()
                , false
                , ResponseKeys.SUCCESS_RESPONSE
                , ResponseKeys.FOUND_IT);
    }


}
