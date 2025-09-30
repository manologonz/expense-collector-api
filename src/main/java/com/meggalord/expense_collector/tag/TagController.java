package com.meggalord.expense_collector.tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meggalord.expense_collector.tag.dto.TagCreateDTO;
import com.meggalord.expense_collector.tag.dto.TagMapper;
import com.meggalord.expense_collector.tag.dto.TagResponseDTO;
import com.meggalord.expense_collector.tag.dto.TagUpdateDTO;
import com.meggalord.expense_collector.utils.pagination.PaginatedResponse;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {

    TagService tagService;
    TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @GetMapping()
    public PaginatedResponse<TagResponseDTO> getTags(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {

        Page<Tag> tagPage = tagService.getTags(page, limit);
        List<TagResponseDTO> data = tagPage.getContent().stream().map(tagMapper::toDTO).collect(Collectors.toList());

        return PaginatedResponse.of(data, page, limit, tagPage.getTotalPages());
    }

    @PostMapping()
    public TagResponseDTO createTag(@RequestBody TagCreateDTO data) {
        Tag newTag = tagService.createTag(data);

        return tagMapper.toDTO(newTag);
    }

    @PutMapping("/{tagId}")
    public TagResponseDTO updateTag(@PathVariable(value = "tagId", required = true) Long tagId,
            @RequestBody TagUpdateDTO data) {
        Tag udpatedTag = tagService.updateTag(tagId, data);

        return tagMapper.toDTO(udpatedTag);
    }

    @GetMapping("/{tagId}")
    public TagResponseDTO getTag(@PathVariable(value = "tagId", required = false) Long tagId) {
        Tag tag = tagService.findTagById(tagId);
        return tagMapper.toDTO(tag);
    }

    @DeleteMapping("/{tagId}")
    public TagResponseDTO deleteTag(@PathVariable(value = "tagId", required = true) Long tagId) {
        Tag deletedTag = tagService.deleteTagById(tagId);
        return tagMapper.toDTO(deletedTag);
    }

}
