package com.pabloagustin.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Request mapping lo omitimos porque la idea es que tenga una ruta nomas!
public class HomeController {
	@GetMapping("/")
	public String home(){
		// En vez de retornar a una vista, retornamos a un redirect y la ruta
		return "forward:/app/index";
	}
}
