package com.vanlang.webbanhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HelloController {
    @GetMapping("/")
    public String HelloPage(){
        return "layout";
    }

}
