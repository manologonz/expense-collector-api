package com.meggalord.expense_collector.tag.dto;

import java.time.Instant;

public record TagResponseDTO(
        Long id,
        String name,
        String slug,
        String color,
        Instant createdAt,
        Instant updatedAt) {

}
