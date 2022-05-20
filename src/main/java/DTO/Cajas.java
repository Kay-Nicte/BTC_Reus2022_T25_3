package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cajas")

public class Cajas {

@Id
private String NumReferencia;

@Column(name = "contenido")
private String contenido;
@Column(name = "valor")
private int valor;


@ManyToOne
@JoinColumn(name = "id_caja")

private Almacenes almacenes;


public Cajas() {
	super();
}


public Cajas(String numReferencia, String contenido, int valor, Almacenes almacenes) {
	super();
	NumReferencia = numReferencia;
	this.contenido = contenido;
	this.valor = valor;
	this.almacenes = almacenes;
}


public String getNumReferencia() {
	return NumReferencia;
}


public void setNumReferencia(String numReferencia) {
	NumReferencia = numReferencia;
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