package com.formacion.app.webmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.webmvc.dao.DepartamentoDAO;
import com.formacion.app.webmvc.entity.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoDAO departamentoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Departamento> getDepartamentos() {
		return departamentoDAO.findAll();
	}

	@Transactional
	@Override
	public Departamento getDepartamento(long id) {
		return departamentoDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Departamento postDepartamento(Departamento departamento) {
		return departamentoDAO.save(departamento);
	}

	@Transactional
	@Override
	public Departamento putDepartamento(Departamento departamento, long id) {
		Departamento toUpdateDepartamento = getDepartamento(id);
		
		if (toUpdateDepartamento==null) return null;
		
		toUpdateDepartamento.setNombre(departamento.getNombre());
		return this.departamentoDAO.save(toUpdateDepartamento);
	}

	@Transactional
	@Override
	public void deleteDepartamento(long id) {
		this.departamentoDAO.deleteById(id);

	}

}
