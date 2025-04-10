package com.app.mybatis.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

// 보고
@Controller
// 이름을 부여 (매핑) 1000/test/test1 (F.C 역할)
@RequestMapping("/test/*")
public class TestController {

//  하위 컨트롤러 작업
// /test/ex get 요청이야? ex경로로 들어왔어?
    // 메서드 하나가 컨트롤러 하나
    // 메서드로 분기점
    // GET : 페이지 요청을 가져옴
    // text/ex : 요청 경로
    // first : 응다 경로 => templates 경로에서 찾는다!
    // 응답과 요청은 전혀 다른 경로
    //Get 방식
    @GetMapping("ex")
//    Post 방식
//    @PostMapping
    public String ex(){
        return "first";
        // string return 가지고 view resolver로
        // templates/first => first.html 만들기
        //"first" : html 경로
    }

    // ./ 현재 ../ 상위 / 최상위
    @GetMapping("/ex01")
    public void ex01 (HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello, World!🤗");
    }
}
