package com.naver.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return null;
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String uId, @RequestParam String uPw) {
        System.out.println("uId = " + uId);
        System.out.println("uPw = " + uPw);
        return null;
    }

}
