package com.datatools.empresasAuto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datatools.empresasAuto.business.IEmpresasService;
import com.datatools.empresasAuto.dto.EmpresaDto;
import com.datatools.empresasAuto.dto.ResponseGenericDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/webresources/servicios/empresa")
public class EmpresaController {
		
	@Autowired
	private IEmpresasService empresaService;	
	
	@PostMapping("/crear")
	public ResponseGenericDTO crear(@RequestBody EmpresaDto empresaDto){				
		return empresaService.crearEmpresa(empresaDto);
	}
	
	@GetMapping("/consultar")
	public ResponseGenericDTO consultar(){				
		return empresaService.consultarEmpresas();
	}


}
