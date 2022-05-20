package DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Almacenes")

public class Almacenes {

@Id 
private int codigo;

@Column(name = "lugar")
private String lugar;
@Column (name="capacidad")
private int capacidad;

@OneToMany
@JoinColumn(name = "codigo")

private List<Cajas> cajas;


public Almacenes() {
	super();
}


public Almacenes(int codigo, String lugar, int capacidad) {
	super();
	this.codigo = codigo;
	this.lugar = lugar;
	this.capacidad = capacidad;
}


public int getCodigo() {
	return codigo;
}


public void setCodigo(int codigo) {
	this.codigo = codigo;
}


public String getLugar() {
	return lugar;
}


public void setLugar(String lugar) {
	this.lugar = lugar;
}


public int getCapacidad() {
	return capacidad;
}


public void setCapacidad(int capacidad) {
	this.capacidad = capacidad;
}


public void setCajas(List<Cajas> cajas) {
	this.cajas = cajas;
}

@JsonIgnore
@OneToMany(fetch = FetchType.LAZY, mappedBy = "Cajas")

public List<Cajas> getCaja(){
return cajas;}

}