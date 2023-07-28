package com.pabloagustin.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {


	@GetMapping({"/index", "/", "" , "/home"})
	public String index(Model model){
		model.addAttribute("titulo", "Enviar parametros de la ruta (@PathVariable)");
		return "variables/index";
	}

	// Una ruta que contiene una variable despues de /string -> dinamico
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model){
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es " + texto);
		return "variables/ver";

	}

	// Enviar dos parametros de la ruta a la URL

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero , Model model){
		model.addAttribute("titulo", "Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es " + texto
		+ " y el numero enviado en el PATH es: " + numero);
		return "variables/ver";

	}

}
