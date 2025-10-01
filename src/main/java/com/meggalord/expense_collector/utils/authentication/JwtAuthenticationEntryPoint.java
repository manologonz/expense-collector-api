package com.meggalord.expense_collector.utils.authentication;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonResponse = "{"
                + "\"error\": \"Unauthorized\","
                + "\"message\": \"" + authException.getMessage() + "\","
                + "\"status\": 401,"
                + "\"path\": \"" + request.getRequestURI() + "\""
                + "}";

        response.getWriter().write(jsonResponse);
    }
}
