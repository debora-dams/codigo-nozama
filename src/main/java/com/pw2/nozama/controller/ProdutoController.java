package com.pw2.nozama.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository prodR;

	@GetMapping(value = "list")
	public String listarProduto(ModelMap model) {
		List<Produto> produtos = prodR.findAll();

		model.addAttribute("listaProdutos", produtos);

		return "produto/list";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String form() {

		return "produto/cadastrar";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String form(Produto produto) {

		prodR.save(produto);

		return "redirect:/produto/list";
	}
	
	@RequestMapping("/deletar")
	public String deletarProduto(Integer id) {
		
		prodR.deleteById(id);
		
		return "redirect:/produto/list";
	}
	
	/*@RequestMapping(value="/listProduto", method = RequestMethod.GET)
	public ModelAndView produtos() {
		ModelAndView andView = new ModelAndView("produto/cadastrar");
		Iterable<Produto> produtos = prodR.findAll();
		andView.addObject("listaProdutos", produtos);
		
		return andView;
	}*/
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView editarProduto(@PathVariable("id") Integer id) {
		
		Optional<Produto> produto = prodR.findById(id);
		
		ModelAndView andView = new ModelAndView("produto/cadastrar");
		andView.addObject("produtoobj", produto.get());
		
		return andView;
	}
}
