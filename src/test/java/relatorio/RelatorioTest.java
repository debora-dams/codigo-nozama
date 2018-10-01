package relatorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.relatorio.Relatorio;

import static org.junit.Assert.assertEquals;

public class RelatorioTest {

	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemCrescente() {

		Produto celular = new Produto("Moto G500", 250.0);
		Produto tv = new Produto("Samsug HD", 300.0);
		Produto dvd = new Produto("CCE DVD", 400.0);

		List<Produto> produtos = new ArrayList<>();
		produtos.add(celular);
		produtos.add(tv);
		produtos.add(dvd);

		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	

	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemDecrescente() {

		Produto dvd = new Produto("CCE DVD", 400.0);
		Produto tv = new Produto("Samsug HD", 300.0);
		Produto celular = new Produto("Moto G500", 250.0);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(celular);
		produtos.add(tv);
		produtos.add(dvd);

		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemAleatoria() {

		Produto tv = new Produto("Samsug HD", 300.0);
		Produto dvd = new Produto("CCE DVD", 400.0);
		Produto celular = new Produto("Moto G500", 250.0);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(celular);
		produtos.add(tv);
		produtos.add(dvd);

		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosComOMesmoProduto() {

		
		Produto celular = new Produto("Moto G500", 250.0);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(celular);

		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 250.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosComOMesmoValor() {

		Produto tv = new Produto("Samsug HD", 300.0);
		Produto dvd = new Produto("CCE DVD", 300.0);
		Produto celular = new Produto("Moto G500", 250.0);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(tv);
		produtos.add(dvd);
		produtos.add(celular);

		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 300.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	

}
