package com.meggalord.expense_collector.tag.dto;

import jakarta.validation.constraints.NotBlank;

public record TagUpdateDTO(@NotBlank String name, @NotBlank String color) {

}
