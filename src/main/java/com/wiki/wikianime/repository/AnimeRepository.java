package com.wiki.wikianime.repository;

import com.wiki.wikianime.entities.Anime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository <Anime,String> {
    
}