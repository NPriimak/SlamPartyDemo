package com.example.micro.smlr.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.CollectionTable;

@Controller
@RequestMapping("/")
public class GreetingController {

    @GetMapping("greeting")
    public String greeting(){
        return "greeting";
    }
}
