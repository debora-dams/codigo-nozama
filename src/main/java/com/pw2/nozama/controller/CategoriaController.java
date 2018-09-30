package com.pw2.nozama.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw2.nozama.model.Categoria;
import com.pw2.nozama.repositories.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("list")
	public String listarCategoria(ModelMap model) {
		List<Categoria> categorias = categoriaRepository.findAll();

		model.addAttribute("listaCategoria", categorias);

		return "categoria/list";
	}

}
