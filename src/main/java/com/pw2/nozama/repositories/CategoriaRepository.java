package com.pw2.nozama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pw2.nozama.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	List<Categoria> findByNomeContainingIgnoreCase(String nome);

}
