package com.platzi.platziprofesores.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="social_media")
public class SocialMedia implements Serializable {
	
	/*
	 * En hibernate, se deben hacer las anotaciones por cada atributo para indicar qué campo de la base de datos está mapeando.
	 * Cada anotación se debe poner anterior a cada atributo de la clase.
	 * Si el campo que se está mapeando es llave primaria, se debe utilizar la anotación @Id
	 * Con la anotación @Column, se indica el nombre exacto de la columna que se está mapeando en la BD
	 * Si requerimos que se administre un campo autoincremental, con la anotación @GeneratedValue, se indica la manera en la que Hibernate lo realiza
	 * a partir del método (strategy) GenerationType. 
	 * 
	 * */
	
	@Id
	@Column(name="id_social_media")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSocialMedia;
		
	@Column(name="name")
	private String name;
	
	@Column(name="icon")
	private String icon;
	
	@OneToMany
	@JoinColumn(name = "id_social_media")
	private Set<TeacherSocialMedia> teacherSocialMedia;
	
	//Constructors
	public SocialMedia(String name, String icon) {
		super();
		this.name = name;
		this.icon = icon;
	}
	
	public SocialMedia() {
		super();
	}

	// Getters y Setters
	public Long getIdSocialMedia() {
		return idSocialMedia;
	}
	public void setIdSocialMedia(Long idSocialMedia) {
		this.idSocialMedia = idSocialMedia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
