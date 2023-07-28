package com.pabloagustin.springbootweb.controllers;

import com.pabloagustin.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

	// Metodos de ACCION o HANDLERS para manejar las HTTP request

	// Controlador por defecto (index)
	// @RequestMapping -> Si omitimos el 'method', queda el GET como request por defecto
	// O podemos simplemente colocar el @ seguido del request. @GetMapping, @PostMapping ..
	// Podemos colocar mas de un path para la request, con LLAVES!

	// Diferentes metodos para pasar valores desde el controlador a la vista. Solo cambia simplicidad de la implementacion
	// Todos conducen a Roma :P
	// 'Model' / 'ModelMap' / 'Map<String, Object>' (map.put) / 'ModelAndView' (This have more details to look for)

	// Aqui en value iria lo que pasariamos desde el application.properties
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	@GetMapping(value = {"/index", "/", "" , "/home"})
	public String index(Model model){
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();

		usuario.setNombre("Pablo");
		usuario.setApellido("Lencinas");

		usuario.setEmail("pabloagus@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model){
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Pablo", "Lencinas", "pabloagus@gmail.com"),
				new Usuario("Juana", "Gonzalez", "juanagon@gmail.com"),
				new Usuario("Fabio", "Lopez", "fabiolop@gmail.com"));
		return usuarios;
	}


}
