package com.example.cpserver.congif;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImp implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        //System.out.println("Unauthorized: " + e.toString()); TODO сделать логирование
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.toString());
    }
}
