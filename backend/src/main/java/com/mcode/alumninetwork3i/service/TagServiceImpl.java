package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.TagEntity;
import com.mcode.alumninetwork3i.exception.TagExistsException;
import com.mcode.alumninetwork3i.exception.TagNotFoundException;
import com.mcode.alumninetwork3i.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public TagEntity getTagById(Long id) {
        return tagRepository.findById(id).orElseThrow(TagNotFoundException::new);
    }

    @Override
    public TagEntity getTagByName(String name) {
        return tagRepository.findTagByName(name).orElseThrow(TagNotFoundException::new);
    }

    @Override
    public TagEntity createNewTag(String name) {
        try {
            TagEntity tag = getTagByName(name);
            if (tag != null) {
                throw new TagExistsException();
            }
        } catch (TagNotFoundException e) {
            TagEntity newTag = new TagEntity();
            newTag.setName(name);
            newTag.setTagUseCounter(1);
            newTag.setDateCreated(new Date());
            newTag.setDateLastModified(new Date());
            return tagRepository.save(newTag);
        }
        return null;
    }

    @Override
    public TagEntity increaseTagUseCounter(String name) {
        TagEntity targetTag = getTagByName(name);
        targetTag.setTagUseCounter(targetTag.getTagUseCounter() + 1);
        targetTag.setDateLastModified(new Date());
        return tagRepository.save(targetTag);
    }

    @Override
    public TagEntity decreaseTagUseCounter(String name) {
        TagEntity targetTag = getTagByName(name);
        targetTag.setTagUseCounter(targetTag.getTagUseCounter() - 1);
        targetTag.setDateLastModified(new Date());
        return tagRepository.save(targetTag);
    }

    @Override
    public List<TagEntity> getTimelineTags() {
        return tagRepository.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "tagUseCounter"))
        ).getContent();
    }
}