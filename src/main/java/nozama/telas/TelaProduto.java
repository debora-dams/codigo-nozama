package nozama.telas;

import java.util.Scanner;

import nozama.dao.ProdutoDAO;
import nozama.model.Produto;

public class TelaProduto {

	static ProdutoDAO pd = new ProdutoDAO();
	static Produto produto = new Produto();
	Scanner ler = new Scanner(System.in);
	Scanner lerNum = new Scanner(System.in);
	// lerNum.useLocale(Locale.US);
	
	public void cadastrarProduto() {
		
		String nome;
		String marca;
		Double preco;
		
		System.out.println("Informe o nome do produto: ");
		nome = ler.nextLine();
		
		System.out.println("Informe a marca do prodto: ");
		marca = ler.nextLine();
		
		System.out.println("Informe o preço do produto: ");
		preco = lerNum.nextDouble();
		
		produto.setNome(nome);
		produto.setMarca(marca);
		produto.setPreco(preco);
		
		pd.salvar(produto);
		
		System.out.println("-- Salvo Com Sucesso --");
		
	}
	
	
}
