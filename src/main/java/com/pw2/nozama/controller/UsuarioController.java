package com.pw2.nozama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pw2.nozama.model.Usuario;
import com.pw2.nozama.repositories.EnderecoRepository;
import com.pw2.nozama.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository endRepor;

	@GetMapping("list")
	public String listarUsuarios(ModelMap model) {

		List<Usuario> usuarios = usuarioRepository.findAll();

		model.addAttribute("listaUsuarios", usuarios);

		return "usuario/list";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarUsuario(ModelMap model) {

		Usuario user = new Usuario();

		model.addAttribute("usuarioobj", user);
		
		return "usuario/cadastrar";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrarUsuario(Usuario user) {
		usuarioRepository.save(user);

		return "redirect:/usuario/list";
	}

	@RequestMapping("/deletar")
	public String deletarUsuario(Integer id) {

		usuarioRepository.deleteById(id);

		return "redirect:/usuario/list";
	}

}
