package com.wiki.wikianime.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.wiki.wikianime.entities.Usuario;
import com.wiki.wikianime.repository.UsuarioRepository;
import com.wiki.wikianime.utils.PasswordG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/registro" })
public class RegistroController {

    @Autowired
    UsuarioRepository usuarioRepo;

    
    @GetMapping({ "/form" })
    public String inicio() {
        return "registro";
    }

    @PostMapping({ "/registrarUsuario" })
    public String registrarUsuario(HttpServletRequest request) {


        PasswordG p = new PasswordG();
        Usuario u = new Usuario();

        String user = request.getParameter("usuario");
        String password = request.getParameter("clave");
        String email = request.getParameter("email");
        String categoria = request.getParameter("categoria");
        Date fechaIngreso = new Date();

        u.setUser(user);        
		u.setPassword(p.encriptador(password));
        u.setEmail(email);
        u.setCategoria(categoria);
        u.setFechaIngreso(fechaIngreso);

        System.out.println(u);

        usuarioRepo.save(u);

        return "redirect:/iniciar";
    }

}