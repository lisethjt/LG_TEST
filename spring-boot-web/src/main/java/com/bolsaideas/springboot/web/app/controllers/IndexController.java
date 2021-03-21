package com.bolsaideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework!");
		return "index.html";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Liseth");
		usuario.setApellido("Jimenez");
		usuario.setEmail("correo@correo");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Liseth", "Jimenez", "liseth@correo"),
				new Usuario("Mariana", "Lambiz", "mariana@correo"), new Usuario("Gerardo", "Herrera", "gerardo@correo"),
				new Usuario("Yasmina", "Cueto", "yasmina@correo"));
		return usuarios;
	}

}