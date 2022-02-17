package com.formacion.app.webmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.webmvc.entity.Departamento;

@Repository
public interface DepartamentoDAO extends JpaRepository<Departamento,Long> {

}
