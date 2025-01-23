package org.cleaning.cleaning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class swaggerController {
    

    @GetMapping("/")
    public String loadSwagger(){
        return "redirect:/swagger-ui/index.html";
    }
    
}
