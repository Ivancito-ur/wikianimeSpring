package com.wiki.wikianime.repository;

import com.wiki.wikianime.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario,String>{

    
}