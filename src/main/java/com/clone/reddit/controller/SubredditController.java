package com.clone.reddit.controller;

import com.clone.reddit.dto.SubredditDto;
import com.clone.reddit.respnse.ListResponse;
import com.clone.reddit.respnse.SingleResultResponse;
import com.clone.reddit.service.SubredditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubredditController {

    private final SubredditService subredditService;

    @RequestMapping(value = "/create-subreddit", method = RequestMethod.GET)
    public SingleResultResponse createSubreddit(@RequestBody SubredditDto subredditDto) {
        return subredditService.save(subredditDto);
    }

    @RequestMapping(path = "/subreddit-page", method = RequestMethod.GET)
    public ListResponse listAll(@RequestParam("page") int page,
                                @RequestParam("size") int size) {

        return subredditService.getSubredditPage(page, size);
    }

    @RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
    public SingleResultResponse getSubreddit(@PathVariable Long id) {
        return subredditService.getById(id);
    }

}
