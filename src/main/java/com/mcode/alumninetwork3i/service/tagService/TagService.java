package com.mcode.alumninetwork3i.service.tagService;

import com.mcode.alumninetwork3i.entity.TagEntity;

import java.util.List;

public interface TagService {
    TagEntity getTagById(Long id);

    TagEntity getTagByName(String name);

    TagEntity createNewTag(String name);

    TagEntity increaseTagUseCounter(String name);

    TagEntity decreaseTagUseCounter(String name);

    List<TagEntity> getTimelineTags();
}
