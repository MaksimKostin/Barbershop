package com.example.barbershop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/barbershop")
public class ClientController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() { return "about"; }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/price")
    public String price() {
        return "price";
    }
}
