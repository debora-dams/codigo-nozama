package nozama.telas;

import java.util.Scanner;

import nozama.dao.PessoaDAO;
import nozama.model.Pessoa;

public class TelaPessoa {
	Scanner ler = new Scanner(System.in);
	static PessoaDAO pd = new PessoaDAO();
	static Pessoa pessoa = new Pessoa();

	public void cadastrarPessoa() {

		String email;
		String nome;

		System.out.println("Infome o seu nome: ");
		nome = ler.nextLine();

		System.out.println("Infome o seu email: ");
		email = ler.nextLine();

		pessoa.setEmail(email);
		pessoa.setNome(nome);

		pd.salvar(pessoa);
		
		System.out.println("-- Salvo Com Sucesso --");
	}

	public void buscarPessoa() {
		String nome;

		System.out.println("Insira o nome da pessoa a ser buscada: ");
		nome = ler.nextLine();

		pd.buscar(nome);

		System.out.println("Codigo: " + pessoa.getId() + "\n" + "Nome: " + pessoa.getNome() + "\n" + "Email: " + pessoa.getEmail());
	}
	
	public void removePessoa() {
		String nome;
		
		System.out.println("Insira o nome da pessoa a ser excluida: ");
		nome = ler.nextLine();
		
		//pd.remover(nome);
	}

}
