package nozama;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import nozama.model.Produto;
import nozama.model.Usuario;

public class App {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		Usuario user = new Usuario();
		/*System.out.println("User encontrado " + user.getId() + "é o " + user.getNome());*/
		user.setNome("vitor");
		user.setEmail("vitor@asd.com");
		user.setSenha("456");
		

		Produto p = new Produto();
		p.setMarca("Motorola");
		p.setNome("Moto E4");
		p.setPreco(579.90);
		p.setQuantidade(8);

		manager.persist(user);
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}
}
