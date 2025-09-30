package com.meggalord.expense_collector.expense.dto;

import java.util.List;

import com.meggalord.expense_collector.tag.dto.TagResponseDTO;

public record ExpenseResponseDTO(Long id, String description, Float amount, List<TagResponseDTO> tags) {

}
