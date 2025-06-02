package com.example.SpringProject.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("isLoggedIn")
    public boolean addLoginStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // 인증 정보가 있고, 인증된 상태이며 익명 사용자가 아니면 true 반환
        return auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
    }
}