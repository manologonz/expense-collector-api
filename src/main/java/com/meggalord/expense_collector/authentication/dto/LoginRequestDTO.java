package com.meggalord.expense_collector.authentication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDTO(@NotBlank @NotNull String email, @NotBlank @NotNull String password) {

}
