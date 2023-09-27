package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.Tag;

import java.util.List;

public interface TagService {
    Tag getTagById(Long id);

    Tag getTagByName(String name);

    Tag createNewTag(String name);

    Tag increaseTagUseCounter(String name);

    Tag decreaseTagUseCounter(String name);

    List<Tag> getTimelineTags();
}
