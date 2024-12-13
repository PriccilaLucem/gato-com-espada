package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Game {
    @GetMapping("/game")
    public String hello() {
      return "index";
    }
}