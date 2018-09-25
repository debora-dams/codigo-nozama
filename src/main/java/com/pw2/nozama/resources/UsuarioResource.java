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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pw2.nozama.model.Usuario;
import com.pw2.nozama.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/buscar")
	public List<Usuario> buscar(@RequestParam("nome") String nome) {
		List<Usuario> usuarios = usuarioRepository.findByNome(nome);

		return usuarios;

	}

	@GetMapping
	public List<Usuario> get() {
		return usuarioRepository.findAll();
	}

	@GetMapping("{id}")
	public Usuario get(@PathVariable("id") Integer id) {
		return usuarioRepository.getOne(id);
	}

	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		usuarioRepository.deleteById(id);
	}

}
