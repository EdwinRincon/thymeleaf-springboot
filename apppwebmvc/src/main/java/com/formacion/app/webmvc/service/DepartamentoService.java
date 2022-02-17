package com.formacion.app.webmvc.service;

import java.util.List;

import com.formacion.app.webmvc.entity.Departamento;


public interface DepartamentoService {

	List<Departamento> getDepartamentos();
	
	Departamento getDepartamento(long id);
	
	Departamento postDepartamento(Departamento departamento);
	
	Departamento putDepartamento(Departamento departamento, long id);
	
	void deleteDepartamento(long id);
}
