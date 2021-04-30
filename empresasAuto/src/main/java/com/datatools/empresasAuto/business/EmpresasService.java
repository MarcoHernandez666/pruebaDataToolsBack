package com.datatools.empresasAuto.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.datatools.empresasAuto.dto.EmpresaDto;
import com.datatools.empresasAuto.dto.ResponseGenericDTO;

@Service
public class EmpresasService implements IEmpresasService {

	@Override
	public ResponseGenericDTO crearEmpresa(EmpresaDto empresaDto) {		
		String nombre = empresaDto.getEmpresa().getNombre();
		try {
			File file = new File("empresasPrueba\\" + nombre + ".dat");
			if (file.exists()) {
				return new ResponseGenericDTO(null, false, "Ya existe una empresa con ese nombre",
						HttpStatus.BAD_REQUEST);
			} else {
				ObjectOutputStream guardarEmpresas = new ObjectOutputStream(
						new FileOutputStream("empresasPrueba\\" + nombre + ".dat"));
				guardarEmpresas.writeObject(empresaDto);
				guardarEmpresas.close();
			}
			return new ResponseGenericDTO(null, true, "Empresa creada correctamente", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseGenericDTO(null, false, "Empresa no fue creada correctamente", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseGenericDTO consultarEmpresas() {
		List<EmpresaDto> arrayListEmpresa = new ArrayList<EmpresaDto>();
		EmpresaDto empresas;
		try {			
			File carpeta = new File("empresasPrueba");
			String[] listaEmpresas = carpeta.list();
			for (String empresaNombre : listaEmpresas) {
				ObjectInputStream leyendoFichero = new ObjectInputStream(
						new FileInputStream("empresasPrueba\\" + empresaNombre));
				empresas = (EmpresaDto) leyendoFichero.readObject();
				leyendoFichero.close();
				arrayListEmpresa.add(empresas);
			}
			return new ResponseGenericDTO(arrayListEmpresa, true, "Consulta exitosa", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseGenericDTO(null, true, "Consulta fallida", HttpStatus.BAD_REQUEST);
		}

	}

}
