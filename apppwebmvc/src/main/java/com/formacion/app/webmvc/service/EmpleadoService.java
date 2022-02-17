package com.formacion.app.webmvc.service;

import java.util.List;

import com.formacion.app.webmvc.entity.Empleado;


public interface EmpleadoService {

	List<Empleado> getEmpleados();
	
	Empleado getEmpleado(long id);
	
	Empleado postEmpleado(Empleado empleado);
	
	Empleado putEmpleado(Empleado empleado, long id);
	
	void deleteEmpleado(long id);
}
