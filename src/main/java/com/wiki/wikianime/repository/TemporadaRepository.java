package com.wiki.wikianime.repository;

import com.wiki.wikianime.entities.Temporada;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporadaRepository extends JpaRepository<Temporada, String> {
    
}