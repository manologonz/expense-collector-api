package com.meggalord.expense_collector.expense.dto;

import java.util.List;

import jakarta.validation.Valid;

public record ExpenseTagUpdateDTO(
        @Valid List<Long> tagIds) {
}
