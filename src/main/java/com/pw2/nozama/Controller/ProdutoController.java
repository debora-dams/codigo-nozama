package com.pw2.nozama.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping(value = "list")
	public String listarProduto(ModelMap model) {
		List<Produto> produtos = produtoRepository.findAll();

		model.addAttribute("listaProdutos", produtos);

		return "produto/list";
	}
}
