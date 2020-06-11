package com.wiki.wikianime.entities;


import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the temporada database table.
 * 
 */
@Entity
@Data
@Table(name = "temporada")
public class Temporada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private int capitulo;

	private String descripcion;

	private String imagen;

	//bi-directional many-to-one association to Anime
	@ManyToOne
	@JoinColumn(name="anime")
	private Anime animeBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario usuario;

	public Temporada() {
    }
}