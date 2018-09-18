package com.pw2.nozama.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@OneToMany
	private List<Produto> produtos = new ArrayList<>();
	@Column
	private Double total;
	
	
	public void adiciona(Produto produto) {
		produtos.add(produto);
		total += produto.getPreco() * 
				produto.getQuantidade();
	}
	
	public void remove(int indiceItem) {
		Produto removido = produtos.remove(indiceItem);
		total -= removido.getPreco() * 
				removido.getQuantidade();
	}
	
	public Integer getTotaldeProdutos() {
		return produtos.size();
	}
	

	public List<Produto> getItens() {
		return produtos;
	}

	public void setItens(List<Produto> itens) {
		this.produtos = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
