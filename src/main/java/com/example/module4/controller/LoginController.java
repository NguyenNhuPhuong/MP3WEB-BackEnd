package com.example.module4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "That's pretty basic!";
    }

}
