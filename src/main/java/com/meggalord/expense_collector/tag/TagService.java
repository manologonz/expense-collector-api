package com.meggalord.expense_collector.tag;

import org.springframework.stereotype.Service;

import com.meggalord.expense_collector.tag.dto.TagCreateDTO;
import com.meggalord.expense_collector.tag.dto.TagMapper;
import com.meggalord.expense_collector.tag.dto.TagUpdateDTO;

import java.util.List;

@Service
public class TagService {

    TagRepository tagRepository;
    TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public Tag findTagById(Long tagId) {
        return tagRepository.findById(tagId).orElseThrow(() -> new IllegalAccessError("Not Found"));
    }

    public Tag findTagBySlug(String tagSlug) {
        List<Tag> result = tagRepository.findBySlug(tagSlug);
        return result.getFirst();
    }

    public Tag createTag(TagCreateDTO data) {
        Tag newTag = tagMapper.toEntity(data);
        return tagRepository.save(newTag);
    }

    public Tag updateTag(Long tagId, TagUpdateDTO data) {
        Tag tag = this.findTagById(tagId);

        if (data.name() != null) {
            tag.setName(data.name());
        }

        if (data.color() != null) {
            tag.setColor(data.color());
        }

        return tagRepository.save(tag);
    }

    public Tag deleteTagById(Long tagId) {
        Tag tag = this.findTagById(tagId);
        tagRepository.delete(tag);

        return tag;
    }
}
