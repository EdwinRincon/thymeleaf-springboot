package com.formacion.app.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.app.webmvc.entity.Empleado;
import com.formacion.app.webmvc.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;

	// Mostrar todos los empleados
	@GetMapping("")
	public String getEmpleados(Model model) {
		model.addAttribute("empleados",empleadoService.getEmpleados());
		return "empleados/empleados";
	}
	
	// Crear nuevo empleado
	@GetMapping("/nuevo")
	public String formularioNuevoEmpleado(Model modelo) {
		Empleado nuevoEmpleado = new Empleado();
		modelo.addAttribute("empleadoKey", nuevoEmpleado);
		return "empleados/nuevo_empleado";
	}
	
	// Nuevo Empleado
	@PostMapping("")
	public String postEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.postEmpleado(empleado);
		return "redirect:/empleados";
	}
	
	
	//Editar empleado
	@GetMapping("/editar/{id}")
	public String formularioEditEmpleado(@PathVariable long id,Model modelo) {
		modelo.addAttribute("empleadoKey", empleadoService.getEmpleado(id));
		return "empleados/editar_empleado";
	}
	
	@PostMapping("/editar/{id}")
	public String putEmpleado(@PathVariable Long id, @ModelAttribute("empleadoKey") Empleado empleado) {
		empleadoService.putEmpleado(empleado, id);
		return "redirect:/empleados";
	}
	
	//Eliminar empleado
	@GetMapping("/eliminar/{id}")
	public String deleteEmpleado(@PathVariable Long id) {
		empleadoService.deleteEmpleado(id);
		return "redirect:/empleados";
	}
	
	
	
}
