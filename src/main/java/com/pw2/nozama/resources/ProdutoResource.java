package com.pw2.nozama.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.model.Usuario;
import com.pw2.nozama.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> get() {
		return produtoRepository.findAll();
	}

	@GetMapping("{id}")
	public Produto get(@PathVariable("id") Integer id) {
		return produtoRepository.getOne(id);
	}

	@PostMapping
	public Produto save(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		produtoRepository.deleteById(id);
	}
}
