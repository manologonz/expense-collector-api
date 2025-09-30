package com.meggalord.expense_collector.expense.dto;

import jakarta.validation.constraints.Positive;

public record ExpenseUpdateDTO(
        String description,
        @Positive(message = "Amount must be greater or equial to 0") Float amount) {
}
