package com.meggalord.expense_collector.utils.authentication.dto;

import com.meggalord.expense_collector.user.dto.UserResponseDTO;

public record AuthResponseDTO(String token, String type, Long expiresIn, UserResponseDTO user) {

}
