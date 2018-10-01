package com.pw2.nozama.relatorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pw2.nozama.model.Produto;

public class Relatorio {

	private Double maiorPreco = Double.NEGATIVE_INFINITY;
	private Double menorPreco = Double.POSITIVE_INFINITY;

	private List<Produto> produtosMaisCaros;

	public void gerarRelatorioPrecos(List<Produto> produtos) {

		for (Produto produto : produtos) {

			if (produto.getPreco() > maiorPreco) {
				maiorPreco = produto.getPreco();
			}
			if (produto.getPreco() < menorPreco) {
				menorPreco = produto.getPreco();
			}
		}

		calcularProdutosMaisCaros(produtos);

	}

	private void calcularProdutosMaisCaros(List<Produto> produtos) {

		produtosMaisCaros = new ArrayList<>(produtos);

		Collections.sort(produtosMaisCaros, new Comparator<Produto>() {
			public int compare(Produto p1, Produto p2) {
				if (p1.getPreco() < p2.getPreco())
					return 1;
				if (p1.getPreco() > p2.getPreco())
					return -1;
				return 0;

			}
		});
		produtosMaisCaros = produtosMaisCaros.subList(0, 
				produtosMaisCaros.size() > 3 ? 3: produtosMaisCaros.size());
		
	}

	public List<Produto> getProdutosMaisCaros() {
		return produtosMaisCaros;
	}

	public Double getMaiorPreco() {
		return maiorPreco;
	}

	public Double getMenorPreco() {
		return menorPreco;
	}

}
