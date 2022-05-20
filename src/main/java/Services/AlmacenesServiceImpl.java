package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.AlmacenesDAO;
import DTO.Almacenes;

@Service

public class AlmacenesServiceImpl implements AlmacenesService{

//Es para decirle a Spring que aplique la autoinyección de dependencias (para traer los métodos del DAO)
@Autowired
AlmacenesDAO almacenesDAO;
	
	@Override
	public List<Almacenes> listarAlmacenes() {
		return almacenesDAO.findAll();
	}

	@Override
	public Almacenes crearAlmacen(Almacenes almacen) {
		return almacenesDAO.save(almacen);
	}

	@Override
	public Almacenes buscarAlmacenCodigo(Long codigo) {
		return almacenesDAO.findById(codigo).get();
	}

	@Override
	public void eliminarAlmacen(Long codigo) {
		almacenesDAO.deleteById(codigo);
	}

	@Override
	public Almacenes modificarAlmacen(Almacenes almacen) {
		return almacenesDAO.save(almacen);
	}

}
