package com.formacion.app.webmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.webmvc.dao.ProyectoDAO;
import com.formacion.app.webmvc.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	ProyectoDAO proyectoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Proyecto> getProyectos() {
		return proyectoDAO.findAll();
	}

	@Transactional
	@Override
	public Proyecto getProyecto(long id) {
		return proyectoDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Proyecto postProyecto(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}

	@Transactional
	@Override
	public Proyecto putProyecto(Proyecto proyecto, long id) {
		Proyecto toUpdateProyecto = getProyecto(id);

		if (toUpdateProyecto == null)
			return null;

		toUpdateProyecto.setNombre(proyecto.getNombre());
		toUpdateProyecto.setFecha_inicio(proyecto.getFecha_inicio());
		toUpdateProyecto.setFecha_fin(proyecto.getFecha_fin());
		toUpdateProyecto.setActivo(proyecto.isActivo());
		return this.proyectoDAO.save(toUpdateProyecto);
	}

	@Transactional
	@Override
	public void deleteProyecto(long id) {
		this.proyectoDAO.deleteById(id);
	}

}
