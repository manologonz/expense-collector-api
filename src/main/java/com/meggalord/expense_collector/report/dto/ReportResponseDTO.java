package com.meggalord.expense_collector.report.dto;

import java.time.Instant;
import java.time.LocalDate;

public record ReportResponseDTO(String name, LocalDate dueDate, Instant createdAt, Instant updatedAt) {

}
