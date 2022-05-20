package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.Cajas;
import Services.CajasServiceImpl;

/**
 * Clase @CajasController. Mappea las funcionalidades con las rutas de
 * la api.
 * 
 * @author Octavio Bernal.
 * @author Ixabel Justo.
 * @author David Dalmau.
 * @author Josep Oriol López.
 *
 */
@RestController
@RequestMapping("/api")
public class CajasController {

	/** Se crea una instancia del tipo @CajasServiceImpl */
	@Autowired
	CajasServiceImpl cajasServiceImpl;

	/** Método para listar cajas */
	@GetMapping("/cajas")
	public List<Cajas> listarCajas() {
		return cajasServiceImpl.listarCajas();
	}

	/** Método para listar cajas por código */
	@GetMapping("/cajas/codigo/{NumReferencia}")
	public List<Cajas> listarCajasCodigo(@PathVariable(name = "NumReferencia") String NumReferencia) {
		return null;
	}

	/** Método para crear una nueva caja */
	@PostMapping("/cajas")
	public Cajas guardarCaja(@RequestBody Cajas cajas) {
		return cajasServiceImpl.crearCajas(cajas);
	}

	/** Método para buscar una caja por codigo */
	@GetMapping("/cajas/{id}")
	public Cajas buscarCajasId(@PathVariable(name = "NumReferencia") String NumReferencia) {
		return cajasServiceImpl.buscarCajasCodigo(NumReferencia);

	}

	/** Método para eliminar una caja */
	@PutMapping("/cajas/{id}")
	public Cajas actualizarCaja(@PathVariable(name = "NumReferencia") String NumReferencia,
			@RequestBody Cajas cajas) {
		/** Se definen instancias del tipo Cajas */
		Cajas caja_a_actualizar = new Cajas();
		Cajas actualizado = new Cajas();
		/** Se filtra la caja a actualizar por código */
		caja_a_actualizar = cajasServiceImpl.buscarCajasCodigo(NumReferencia);
		/** Se actualizan los valores */
		caja_a_actualizar.setNumReferencia(cajas.getNumReferencia());
		caja_a_actualizar.setContenido(cajas.getContenido());
		caja_a_actualizar.setValor(cajas.getValor());
		caja_a_actualizar.setAlmacenes(cajas.getAlmacenes());

		actualizado = cajasServiceImpl.modificarCajas(caja_a_actualizar);

		return actualizado;
	}

	/** Método para eliminar una caja */
	@DeleteMapping("/cajas/{id}")
	public void eliminarCaja(@PathVariable(name = "NumReferencia") String NumReferencia) {
		cajasServiceImpl.eliminarCajas(NumReferencia);
		System.out.println("Caja eliminada con exito.");
	}
}