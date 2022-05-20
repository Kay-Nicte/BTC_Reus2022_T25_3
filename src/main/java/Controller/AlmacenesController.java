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

import DTO.Almacenes;
import Services.AlmacenesServiceImpl;

/**
 * Clase @AlmacenesController. Mappea las funcionalidades con las rutas de
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
public class AlmacenesController {

	/** Se crea una instancia del tipo @AlmacenesServiceImpl */
	@Autowired
	AlmacenesServiceImpl almacenesServiceImpl;

	/** Método para listar almacenes */
	@GetMapping("/almacenes")	
	public List<Almacenes> listarAlmacenes() {
		return almacenesServiceImpl.listarAlmacenes();
	}

	/** Método para listar almacenes por código */
	@GetMapping("/almacenes/codigo/{codigo}")
	public List<Almacenes> listarAlmacenCodigo(@PathVariable(name = "codigo") String codigo) {
		return null;
	}

	/** Método para crear un nuevo almacén */
	@PostMapping("/almacenes")
	public Almacenes crearAlmacen(@RequestBody Almacenes almacenes) {
		return almacenesServiceImpl.crearAlmacen(almacenes);
	}

	/** Método para buscar un almacén por codigo */
	@GetMapping("/almacenes/{id}")
	public Almacenes buscarAlmacenesId(@PathVariable(name = "codigo") Long codigo) {
		return almacenesServiceImpl.buscarAlmacenCodigo(codigo);

	}

	/** Método para actualizar un almacén */
	@PutMapping("/almacenes/{id}")
	public Almacenes actualizarAlmacen(@PathVariable(name = "codigo") Long codigo,
			@RequestBody Almacenes almacenes) {
		/** Se definen instancias del tipo Almacenes */
		Almacenes almacen_a_actualizar = new Almacenes();
		Almacenes actualizado = new Almacenes();
		/** Se filtra el almacén a actualizar por código */
		almacen_a_actualizar = almacenesServiceImpl.buscarAlmacenCodigo(codigo);
		/** Se actualizan los valores */
		almacen_a_actualizar.setCodigo(almacenes.getCodigo());
		almacen_a_actualizar.setLugar(almacenes.getLugar());
		almacen_a_actualizar.setCapacidad(almacenes.getCapacidad());

		actualizado = almacenesServiceImpl.modificarAlmacen(almacen_a_actualizar);

		return actualizado;
	}

	/** Método para eliminar un almacén */
	@DeleteMapping("/almacenes/{id}")
	public void eliminarAlmacen(@PathVariable(name = "codigo") Long codigo) {
		almacenesServiceImpl.eliminarAlmacen(codigo);
		System.out.println("Almacén eliminado con exito.");
	}
}