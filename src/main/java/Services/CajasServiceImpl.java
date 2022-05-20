package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.CajasDAO;
import DTO.Cajas;

@Service

public class CajasServiceImpl implements CajasService{

@Autowired
CajasDAO cajasDAO;	
	
	@Override
	public List<Cajas> listarCajas() {
		return cajasDAO.findAll();
	}

	@Override
	public Cajas crearCajas(Cajas cajas) {
		return cajasDAO.save(cajas);
	}

	@Override
	public Cajas buscarCajasCodigo(String NumReferencia) {
		return cajasDAO.findById(NumReferencia).get();
	}

	@Override
	public void eliminarCajas(String NumReferencia) {
		cajasDAO.deleteById(NumReferencia);
	}

	@Override
	public Cajas modificarCajas(Cajas cajas) {
		return cajasDAO.save(cajas);
	}

}