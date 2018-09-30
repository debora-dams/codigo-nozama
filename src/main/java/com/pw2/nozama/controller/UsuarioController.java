package com.pw2.nozama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw2.nozama.model.Usuario;
import com.pw2.nozama.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("list")
	public String listarUsuarios(ModelMap model) {

		List<Usuario> usuarios = usuarioRepository.findAll();

		model.addAttribute("listaUsuarios", usuarios);

		return "usuario/list";
	}

}
