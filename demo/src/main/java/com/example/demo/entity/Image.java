package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image extends BaseEntity<Long>{

	private static final long serialVersionUID = -2799556002006030284L;

	@Column(name="user_id")
	private Long userId;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="imagem")
	private byte[] imagem;

	public Long getUser() {
		return userId;
	}

	public void setUser(Long user) {
		this.userId = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String linkImagem) {
		this.nome = linkImagem;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
}
