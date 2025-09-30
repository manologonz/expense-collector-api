package com.meggalord.expense_collector.tag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TagCreateDTO(@NotNull @NotBlank String name, @NotNull @NotBlank String color) {

}
