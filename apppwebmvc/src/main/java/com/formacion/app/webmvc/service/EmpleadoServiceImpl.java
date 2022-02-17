package com.formacion.app.webmvc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.webmvc.dao.EmpleadoDAO;
import com.formacion.app.webmvc.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDAO empleadoDAO;
	
	@Transactional(readOnly=true)
	@Override
	public List<Empleado> getEmpleados() {
		return empleadoDAO.findAll();
	}

	@Transactional
	@Override
	public Empleado getEmpleado(long id) {
		return empleadoDAO.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public Empleado postEmpleado(Empleado empleado) {
		return empleadoDAO.save(empleado);
	}

	@Transactional
	@Override
	public Empleado putEmpleado(Empleado empleado, long id) {
		Empleado toUpdateEmpleado = getEmpleado(id);
		
		if (toUpdateEmpleado==null) return null;
		
		toUpdateEmpleado.setNombre(empleado.getNombre());
		toUpdateEmpleado.setApellido(empleado.getApellido());
		toUpdateEmpleado.setEmail(empleado.getEmail());
		toUpdateEmpleado.setTelefono(empleado.getTelefono());
		return this.empleadoDAO.save(toUpdateEmpleado);
	}

	@Transactional
	@Override
	public void deleteEmpleado(long id) {
		this.empleadoDAO.deleteById(id);
	}



}
