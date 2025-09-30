package com.meggalord.expense_collector.expense.dto;

import org.springframework.stereotype.Component;

import com.meggalord.expense_collector.expense.Expense;
import com.meggalord.expense_collector.tag.TagService;
import com.meggalord.expense_collector.tag.dto.TagResponseDTO;
import com.meggalord.expense_collector.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseMapper {
    private final TagService tagService;

    public ExpenseMapper(TagService tagService) {
        this.tagService = tagService;
    }

    public Expense toEntity(ExpenseCreateDTO dto) {
        Expense expense = new Expense();
        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());

        if (dto.tagIds() != null && !dto.tagIds().isEmpty()) {
            List<Tag> tags = dto.tagIds().stream().map(tagService::findTagById).collect(Collectors.toList());
            expense.setTags(tags);
        }

        return expense;
    }

    public ExpenseResponseDTO toDTO(Expense expense) {
        List<TagResponseDTO> tagList = new ArrayList<TagResponseDTO>();

        if (expense.getTags() != null && !expense.getTags().isEmpty()) {
            tagList = expense.getTags().stream()
                    .map(tag -> new TagResponseDTO(tag.getId(), tag.getName(), tag.getSlug(), tag.getColor()))
                    .collect(Collectors.toList());
        }

        return new ExpenseResponseDTO(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                tagList);
    }
}
