package com.meggalord.expense_collector.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(@NotBlank String username, @NotBlank String password) {

}
