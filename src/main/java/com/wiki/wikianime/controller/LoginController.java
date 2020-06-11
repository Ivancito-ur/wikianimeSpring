package com.wiki.wikianime.controller;

import com.wiki.wikianime.repository.AnimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @Autowired
    AnimeRepository aRepository;

    @GetMapping({"/","/index"})
    public String inicio(Model modelo) {
        modelo.addAttribute("anime", aRepository.findAll());
        return "index";
    }

    @GetMapping({"/iniciar"})
    public String iniciarSesion() {
        return "iniciar";
    }
}