package com.explore.featuredemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/demo")
public class DemoController {


    @GetMapping("/feature")
    public String getFeature() {
        return "hello";
    }


}
