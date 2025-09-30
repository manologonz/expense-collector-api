package com.meggalord.expense_collector.report.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportCreateDTO(@NotNull @NotBlank String name, @NotBlank LocalDate duDate) {

}
