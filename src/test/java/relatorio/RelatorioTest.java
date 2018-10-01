package relatorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.relatorio.Relatorio;

import static org.junit.Assert.assertEquals;

public class RelatorioTest {
	
	private Relatorio relatorio;
	
	private List<Produto> produtos;
	
	@Before
	public void criarEntidadesParaTestes() {
		
		relatorio = new Relatorio();
		Produto tv = new Produto("Samsug HD", 300.0);
		Produto dvd = new Produto("CCE DVD", 250.0);
		Produto celular = new Produto("Moto G500", 400.0);
		
		
		produtos = new ArrayList<>();
		produtos.add(tv);
		produtos.add(dvd);
		produtos.add(celular);
		
	}

	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemCrescente() {
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	

	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemDecrescente() {
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosEmOrdemAleatoria() {
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosComOMesmoProduto() {
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 250.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOMaiorEMenorPrecoDosProdutosComOMesmoValor() {
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);

		Double maiorPrecoEsperado = 300.0;
		Double menorPrecoEsperado = 250.0;

		assertEquals(maiorPrecoEsperado, relatorio.getMaiorPreco());
		assertEquals(menorPrecoEsperado, relatorio.getMenorPreco());
	}
	
	@Test
	public void deveEncontrarOsProdutosMaisCaros() {
		
		Produto caneta = new Produto("Caneta Bike", 1.0);
		produtos.add(caneta);
		relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);
		
		List<Produto> top3ProdutosMaisCaros = relatorio.getProdutosMaisCaros();
		assertEquals(3, top3ProdutosMaisCaros.size());
		assertEquals(new Double (400.0), top3ProdutosMaisCaros.get(0).getPreco());
		assertEquals(new Double (300.0), top3ProdutosMaisCaros.get(1).getPreco());
		assertEquals(new Double (250.0), top3ProdutosMaisCaros.get(2).getPreco());
		
	}

}
