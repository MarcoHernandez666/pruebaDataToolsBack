package com.datatools.empresasAuto.dto;

import java.io.Serializable;

import com.datatools.empresasAuto.entity.EmpresaEntity;

public class EmpresaDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EmpresaEntity empresa;

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}
	

}
