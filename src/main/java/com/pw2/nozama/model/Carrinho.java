package com.pw2.nozama.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();
	@Column
	private Double total;

	public void adiciona(Produto produto) {
		produtos.add(produto);
		total += produto.getPreco() * produto.getQuantidadeDeEstoque();
	}

	public void remove(int indiceItem) {
		Produto removido = produtos.remove(indiceItem);
		total -= removido.getPreco() * removido.getQuantidadeDeEstoque();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
