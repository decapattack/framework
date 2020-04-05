package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity<Long>{

	private static final long serialVersionUID = 302931993718791165L;

	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="corpo")
	private String corpo;
	
	@Transient
	private List<Comment> comentarios;

	public Long getUser() {
		return userId;
	}

	public void setUser(Long user) {
		this.userId = user;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public List<Comment> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comment> comentarios) {
		this.comentarios = comentarios;
	}

}
