package com.meggalord.expense_collector.authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.meggalord.expense_collector.authentication.dto.CredentialsResponseDTO;
import com.meggalord.expense_collector.authentication.dto.LoginRequestDTO;
import com.meggalord.expense_collector.user.UserService;
import com.meggalord.expense_collector.user.dto.UserRegisterDTO;
import com.meggalord.expense_collector.user.dto.UserResponseDTO;
import com.meggalord.expense_collector.utils.authentication.JwtUtil;
import com.meggalord.expense_collector.utils.authentication.dto.AuthResponseDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<CredentialsResponseDTO> login(@RequestBody LoginRequestDTO requestBody) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestBody.email(), requestBody.password()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);

        CredentialsResponseDTO response = new CredentialsResponseDTO(
                token,
                86400L);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<CredentialsResponseDTO> register(@Valid @RequestBody UserRegisterDTO registerRequest) {
        UserResponseDTO user = userService.createUser(registerRequest);

        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        AuthResponseDTO response = new CredentialsResponseDTO(
                token,
                86400L);

        return ResponseEntity.ok(response);
    }
}
