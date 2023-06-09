package com.ohye.mini_pj.web;

import com.ohye.mini_pj.web.dto.HelloResponseDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@Param("name") String name, @Param("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
