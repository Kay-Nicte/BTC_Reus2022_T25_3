package com.crud.springmaven.Services;

import java.util.List;

import com.crud.springmaven.DTO.Almacenes;

public interface AlmacenesService {

	public List<Almacenes> listarAlmacenes();

	public Almacenes crearAlmacen(Almacenes almacen);

	public Almacenes buscarAlmacenCodigo(Long codigo);

	public void eliminarAlmacen(Long codigo);

	public Almacenes modificarAlmacen(Almacenes almacen);

}