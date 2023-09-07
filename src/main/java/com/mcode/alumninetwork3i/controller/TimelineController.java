package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.entity.TagEntity;
import com.mcode.alumninetwork3i.response.PostResponse;
import com.mcode.alumninetwork3i.service.postService.PostService;
import com.mcode.alumninetwork3i.service.tagService.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TimelineController {
    private final PostService postService;
    private final TagService tagService;

    @GetMapping("/")
    public ResponseEntity<?> getTimelinePosts(@RequestParam("page") Integer page,
                                              @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page - 1;
        size = size <= 0 ? 5 : size;
        List<PostResponse> timelinePosts = postService.getTimelinePostsPaginate(page, size);
        return new ResponseEntity<>(timelinePosts, HttpStatus.OK);
    }

    @GetMapping("/tags")
    public ResponseEntity<?> getTimelineTags() {
        List<TagEntity> timelineTags = tagService.getTimelineTags();
        return new ResponseEntity<>(timelineTags, HttpStatus.OK);
    }
}
