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

import com.pw2.nozama.model.Endereco;
import com.pw2.nozama.repositories.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

	@Autowired
	EnderecoRepository enderecoRepository;

	@GetMapping
	public List<Endereco> get() {
		return enderecoRepository.findAll();
	}

	
	@GetMapping("{id}")
	public Endereco get(@PathVariable("id") Integer id) {
		return enderecoRepository.getOne(id);

	}
	
	@PostMapping
	public Endereco salvar(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@PutMapping
	public Endereco atualizar(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Integer id) {
		enderecoRepository.deleteById(id);
	}

}
