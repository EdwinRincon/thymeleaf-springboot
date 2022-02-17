package com.formacion.app.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.app.webmvc.entity.Departamento;
import com.formacion.app.webmvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	// Mostrar todos los empleados
	@GetMapping("")
	public String getDepartamentos(Model model) {
		model.addAttribute("departamentos",departamentoService.getDepartamentos());
		return "departamentos/departamentos";
	}
	
	// Crear nuevo departamento
	@GetMapping("/nuevo")
	public String formularioNuevoDepartamento(Model modelo) {
		Departamento nuevoDepartamento = new Departamento();
		modelo.addAttribute("departamentoKey", nuevoDepartamento);
		return "departamentos/nuevo_departamento";
	}
	
	// Nuevo departamento
	@PostMapping("")
	public String postDepartamento(@ModelAttribute("departamento") Departamento departamento) {
		departamentoService.postDepartamento(departamento);
		return "redirect:/departamentos";
	}
	
	
	//Editar departamento
	@GetMapping("/editar/{id}")
	public String formularioEditDepartamento(@PathVariable long id,Model modelo) {
		modelo.addAttribute("departamentoKey", departamentoService.getDepartamento(id));
		return "departamentos/editar_departamento";
	}
	
	@PostMapping("/editar/{id}")
	public String putDepartamento(@PathVariable Long id, @ModelAttribute("departamentoKey") Departamento departamento) {
		departamentoService.putDepartamento(departamento, id);
		return "redirect:/departamentos";
	}
	
	//Eliminar departamento
	@GetMapping("/eliminar/{id}")
	public String deleteDepartamento(@PathVariable Long id) {
		departamentoService.deleteDepartamento(id);
		return "redirect:/departamentos";
	}
	
	
	
}
