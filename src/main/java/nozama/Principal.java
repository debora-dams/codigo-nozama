package nozama;

import nozama.model.Produto;
import nozama.model.Usuario;
import nozama.telas.TelaPessoa;

public class Principal {
	public static void main(String[] args) {
		
		  /*EntityManager manager = JPAUtil.getEntityManager(); 
		  EntityTransaction tx = manager.getTransaction(); 
		  tx.begin();*/
		 

		// Usuario user = manager.find(Usuario.class, 2L);

		Usuario user = new Usuario();
		// System.out.println("User encontrado " + user.getId() + "é o " +
		// user.getNome());
		user.setNome("Eliabão");
		user.setEmail("eliabao@asd.com");
		user.setSenha("00000");
		user.setTelefone("xxxx-xxxx");

		Produto p = new Produto();
		p.setMarca("Apple");
		p.setNome("iPhone X");
		p.setPreco(10.000);
		p.setQuantidade(2);

		// manager.merge(p);

		TelaPessoa tp = new TelaPessoa();
		tp.cadastrarPessoa();
		//tp.buscarPessoa();
		
		//PessoaDAO pd = new PessoaDAO();
		//pd.buscar("pedro");
		
		/*Pessoa pe = new Pessoa();
		pe = manager.find(Pessoa.class, 1L);
		
		System.out.println(pe.getNome());
		*/
		
		
		  /*tx.commit(); 
		  manager.close(); 
		  JPAUtil.close();*/
		 

	}
}
