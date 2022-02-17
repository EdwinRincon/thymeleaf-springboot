package com.formacion.app.webmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.webmvc.entity.Empleado;

@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado,Long> {

}
