package com.naver.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Locale locale, Model model, HttpServletRequest request) {
        return "home";
    }
}
