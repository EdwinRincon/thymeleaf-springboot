package com.formacion.app.webmvc.service;

import java.util.List;

import com.formacion.app.webmvc.entity.Proyecto;


public interface ProyectoService {

	List<Proyecto> getProyectos();
	
	Proyecto getProyecto(long id);
	
	Proyecto postProyecto(Proyecto proyecto);
	
	Proyecto putProyecto(Proyecto proyecto, long id);
	
	void deleteProyecto(long id);
}
