package com.tbo.villa_api.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    // API Key yang di-hardcode sesuai instruksi tugas
    private static final String API_KEY = "TBO-API-2025";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key = request.getHeader("X-API-KEY");

        if (API_KEY.equals(key)) {
            return true; // Akses diizinkan
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized: API key missing or invalid");
        return false;
    }
}
