package com.example.miniproject.controller;

import com.example.miniproject.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random-color")
public class ColorController {
    @Autowired
    private ColorService colorService;
    @GetMapping()
    public String randomColor(@RequestParam int type) {
        return colorService.getTypeValue(type);

    }

}
