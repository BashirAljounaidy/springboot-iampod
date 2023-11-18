package com.aljounaidy.iampod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebServer {

    @Autowired
    private VersionService versionService;

    @GetMapping("/")
    public String index(@RequestParam(name = "version", required = false, defaultValue = "1.0") String version, Model model) {
        model.addAttribute("version", versionService.getVersion());
        return "index";
    }
}
