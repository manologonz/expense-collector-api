package com.meggalord.expense_collector.expense.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ExpenseCreateDTO(
        @NotBlank(message = "Description is required") String description,
        @NotNull(message = "Amount is required") @Positive(message = "Amount must be greater or equial to 0") Float amount,
        @Valid List<Long> tagIds) {
}
