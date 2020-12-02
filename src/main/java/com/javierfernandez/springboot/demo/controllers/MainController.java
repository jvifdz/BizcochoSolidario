package com.javierfernandez.springboot.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("titulo", "Esto es un reto");
        return "index";
    }
}
