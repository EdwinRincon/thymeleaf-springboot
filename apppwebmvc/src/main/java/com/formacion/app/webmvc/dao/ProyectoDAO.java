package com.formacion.app.webmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.webmvc.entity.Proyecto;

@Repository
public interface ProyectoDAO extends JpaRepository<Proyecto,Long> {

}
