package com.meggalord.expense_collector.tag.dto;

import org.springframework.stereotype.Component;

import com.meggalord.expense_collector.tag.Tag;

@Component
public class TagMapper {

    public Tag toEntity(TagCreateDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.name());
        tag.setColor(dto.color());

        return tag;
    }

    public TagResponseDTO toDTO(Tag tag) {
        return new TagResponseDTO(
                tag.getId(),
                tag.getName(),
                tag.getSlug(),
                tag.getColor());
    }
}
