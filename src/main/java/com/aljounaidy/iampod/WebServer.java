package com.aljounaidy.iampod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebServer {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
