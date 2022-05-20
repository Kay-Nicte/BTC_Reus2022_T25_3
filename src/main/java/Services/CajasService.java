package Services;

import java.util.List;

import DTO.Cajas;

public interface CajasService {
	
	public List<Cajas> listarCajas();
	public Cajas crearCajas(Cajas cajas);
	public Cajas buscarCajasCodigo(String NumReferencia);
	public void  eliminarCajas(String NumReferencia);
	public Cajas modificarCajas(Cajas cajas);

}