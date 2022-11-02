package org.example.overview.members.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;

@ControllerAdvice
// 모든 컨트롤러가 호출되기 전에 전역적으로 호출되는 메서드
// 보통 공통적인 예외처리나 로깅 찍을 때 사용
public class GlobalController {

    @ModelAttribute("serverTime")
    public String getServerTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        return localDateTime.toString();
    }

}
