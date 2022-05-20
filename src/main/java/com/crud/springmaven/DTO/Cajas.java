package com.crud.springmaven.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cajas")

public class Cajas {

	@Id
	@Column(name = "num_referencia")
	private String num_referencia;

	@Column(name = "contenido")
	private String contenido;
	@Column(name = "valor")
	private int valor;

	@ManyToOne
	@JoinColumn(name = "id_almacen")

	private Almacenes almacenes;

	public Cajas() {
	}

	public Cajas(String num_referencia, String contenido, int valor, Almacenes almacenes) {
		super();
		this.num_referencia = num_referencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacenes = almacenes;
	}

	public String getNumReferencia() {
		return num_referencia;
	}

	public void setNumReferencia(String num_referencia) {
		this.num_referencia = num_referencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacenes getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(Almacenes almacenes) {
		this.almacenes = almacenes;
	}

}