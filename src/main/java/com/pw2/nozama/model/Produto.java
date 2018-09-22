package com.pw2.nozama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String nome;
	@Column
	private Double preco;
	@Column
	private String marca;
	@Column
	private Integer quantidadeDeEstoque;

	public Produto(String nome, Double preco, Integer codigoProd, String marca) {
		this.nome = nome;
		this.preco = preco;
		this.id = codigoProd;
		this.marca = marca;
	}

	public Produto() {

	}

	public Integer getCodigoProd() {
		return id;
	}

	public void setCodigoProd(Integer codigoProd) {
		this.id = codigoProd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getQuantidadeDeEstoque() {
		return quantidadeDeEstoque;
	}

	public void setQuantidadeDeEstoque(Integer quantidadeDeEstoque) {
		this.quantidadeDeEstoque = quantidadeDeEstoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
