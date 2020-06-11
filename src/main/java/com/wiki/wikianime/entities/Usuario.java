package com.wiki.wikianime.entities;


import java.io.Serializable;
import javax.persistence.*;


import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="user")
	private String user;

	@Column(name="categoria")
	private String categoria;

	@Column(name="email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="password")
	private String password;

	//bi-directional many-to-one association to Anime
	@OneToMany(mappedBy="usuario")
	private List<Anime> animes;

	//bi-directional many-to-one association to Temporada
	@OneToMany(mappedBy="usuario")
	private List<Temporada> temporadas;
	public Usuario() {
	}


}