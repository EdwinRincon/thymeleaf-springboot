package com.formacion.app.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.app.webmvc.entity.Proyecto;
import com.formacion.app.webmvc.service.ProyectoService;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;

	// Mostrar todos los proyectos
	@GetMapping("")
	public String getProyectos(Model model) {
		model.addAttribute("proyectos",proyectoService.getProyectos());
		return "proyectos/proyectos";
	}
	
	// Crear nuevo proyecto
	@GetMapping("/nuevo")
	public String formularioNuevoEmpleado(Model modelo) {
		Proyecto nuevoProyecto = new Proyecto();
		modelo.addAttribute("proyectoKey", nuevoProyecto);
		return "proyectos/nuevo_proyecto";
	}
	
	// Nuevo Proyecto
	@PostMapping("")
	public String postProyecto(@ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoService.postProyecto(proyecto);
		return "redirect:/proyectos";
	}
	
	
	//Editar proyecto
	@GetMapping("/editar/{id}")
	public String formularioEditProyecto(@PathVariable long id,Model modelo) {
		modelo.addAttribute("proyectoKey", proyectoService.getProyecto(id));
		return "proyectos/editar_proyecto";
	}
	
	@PostMapping("/editar/{id}")
	public String putProyecto(@PathVariable Long id, @ModelAttribute("proyectoKey") Proyecto proyecto) {
		proyectoService.putProyecto(proyecto, id);
		return "redirect:/proyectos";
	}
	
	//Eliminar proyecto
	@GetMapping("/eliminar/{id}")
	public String deleteProyecto(@PathVariable Long id) {
		proyectoService.deleteProyecto(id);
		return "redirect:/proyectos";
	}
	
	
	
}
