package com.praticaintegradoraum.algarismosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping
    public String ola() {
        return "Olá !!!";
    }
}
