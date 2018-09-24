package relatorio;

import java.util.ArrayList;
import java.util.List;

import com.pw2.nozama.model.Produto;
import com.pw2.nozama.relatorio.Relatorio;

public class TesteDoRelatorio {
	public static void main(String[] args) {
		
		Produto celular = new Produto ("Moto G500", 250.0);
		Produto tv = new Produto ("Samsug HD", 300.0);
		Produto dvd = new Produto ("CCE DVD",400.0);
		
		List<Produto>produtos = new ArrayList<>();
		produtos.add(celular);
		produtos.add(tv);
		produtos.add(dvd);
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerarRelatorioPrecos(produtos);
		
		
		Double maiorPrecoEsperado = 400.0;
		Double menorPrecoEsperado = 250.0;
		
		
		System.out.println(maiorPrecoEsperado.equals(relatorio.getMaiorPreco()));
		
		System.out.println(menorPrecoEsperado.equals(relatorio.getMenorPreco()));
	}

}
