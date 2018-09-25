package com.pw2.nozama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pw2.nozama.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	List<Produto> findByNomeContainingIgnoreCase(String nome);
	

}
