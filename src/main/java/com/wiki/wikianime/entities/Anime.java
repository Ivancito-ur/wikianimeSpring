package com.wiki.wikianime.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the anime database table.
 * 
 */
@Entity
@Data
@Table(name = "anime")
public class Anime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private int capitulo;

	private String categoria;

	private String descripcion;

	private String imagen;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario usuario;

	//bi-directional many-to-one association to Temporada
	@OneToMany(mappedBy="animeBean")
	private List<Temporada> temporadas;

	public Anime() {
    }
}