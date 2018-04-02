package com.chant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @GetMapping(value="/hi")
    public String hello() {
        return "hi";
    }
}
