package com.datatools.empresasAuto.business;

import com.datatools.empresasAuto.dto.EmpresaDto;
import com.datatools.empresasAuto.dto.ResponseGenericDTO;

public interface IEmpresasService {
	
	ResponseGenericDTO crearEmpresa (EmpresaDto empresaDto);

	ResponseGenericDTO consultarEmpresas();
}
