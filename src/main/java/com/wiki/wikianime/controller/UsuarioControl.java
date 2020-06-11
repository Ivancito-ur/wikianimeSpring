package com.wiki.wikianime.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.wiki.wikianime.entities.Anime;
import com.wiki.wikianime.entities.Temporada;
import com.wiki.wikianime.entities.Usuario;
import com.wiki.wikianime.repository.AnimeRepository;
import com.wiki.wikianime.repository.TemporadaRepository;
import com.wiki.wikianime.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/perfil/" })
public class UsuarioControl {

    @Autowired
    AnimeRepository aRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TemporadaRepository tRepository;

    public static String home = "redirect:/perfil/";

    @GetMapping({ "/" })
    public String perfil(Model modelo) {

        modelo.addAttribute("anime", aRepository.findAll());

        /*Optional<Usuario> uOptional = usuarioRepository.findById(request.getParameter("user"));

        Usuario usuario = uOptional.get();

        modelo.addAttribute("user", usuario);
        modelo.addAttribute("animes", usuario.getAnimes());*/

        return "perfil";
    }

    @GetMapping({ "/agregar_anime" })
    public String agregarAnimeForm() {
        return "agregarA";
    }

    @PostMapping({ "/agregando_anime" })
    public String agregandoAnime(HttpServletRequest request) {

        Anime a = new Anime();

        Optional<Usuario> uOptional = usuarioRepository.findById(request.getParameter("user"));

        Usuario u = uOptional.get();

        a.setNombre(request.getParameter("nombre"));
        a.setCapitulo(Integer.valueOf(request.getParameter("capitulo")));
        a.setCategoria(request.getParameter("categoria"));
        a.setImagen(request.getParameter("imagen"));
        a.setDescripcion(request.getParameter("descripcion"));
        a.setUsuario(u);

        aRepository.save(a);

        return home;
    }

    @GetMapping({ "/agregar_temporada" })
    public String agregarTemporadaForm(Model modelo) {
        modelo.addAttribute("todos", aRepository.findAll());
        return "agregarT";
    }

    @PostMapping({ "/agregando_temporada" })
    public String agregarTemporada(HttpServletRequest request) {

        Temporada t = new Temporada();
        
        Optional<Usuario> uOptional = usuarioRepository.findById(request.getParameter("user"));

        Usuario u = uOptional.get();

        Optional<Anime> uOptional2 = aRepository.findById(request.getParameter("anime"));

        Anime a = uOptional2.get();

        t.setNombre(request.getParameter("nombre"));
        t.setCapitulo(Integer.parseInt(request.getParameter("cap")));
        t.setDescripcion(request.getParameter("descripcion"));
        t.setImagen(request.getParameter("img"));
        t.setUsuario(u);
        t.setAnimeBean(a);
        
        tRepository.save(t);

        return home;
    }
    
    @GetMapping( "/{nombre:.+}" )
    public String verAnime(Model modelo, @PathVariable String nombre) {

            Optional<Anime> animeOpt = aRepository.findById(nombre);

            Anime anime = animeOpt.get();

            modelo.addAttribute("anime", anime);
            modelo.addAttribute("temporada", anime.getTemporadas());

        return "anime";

    }

    
    @GetMapping( "/{nombre:.+}/{nombre:.+}"  )
    public String verTemporada(Model modelo, @PathVariable String nombre) {

        Optional<Temporada> tempOpt = tRepository.findById(nombre);

        Temporada temp = tempOpt.get();

        modelo.addAttribute("temporada", temp);


        return "temporada";
    }

    

}