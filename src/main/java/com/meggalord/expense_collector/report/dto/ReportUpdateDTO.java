package com.meggalord.expense_collector.report.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record ReportUpdateDTO(@NotBlank String name, @NotBlank LocalDate duDate) {

}
