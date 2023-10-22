package com.wit.S17.challange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlClass {
        @GetMapping("/")
        public String control() {
            return "Bilge";
        }
}