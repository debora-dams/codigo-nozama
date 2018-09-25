package com.pw2.nozama.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pw2.nozama.model.Categoria;
import com.pw2.nozama.repositories.CategoriaRepository;

public class CategoriaResource {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> get() {
		return categoriaRepository.findAll();
	}

	@GetMapping("{id}")
	public Categoria get(@PathVariable("id") Integer id) {
		return categoriaRepository.getOne(id);
	}

	@PostMapping
	public Categoria save(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@PutMapping
	public Categoria update(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		categoriaRepository.deleteById(id);
	}
	
	@GetMapping("/buscar")
	public List<Categoria> buscar(@RequestParam("nome") String nome) {
		List<Categoria> usuarios = categoriaRepository.findByNomeContainingIgnoreCase(nome);
		return usuarios;

	}
}
