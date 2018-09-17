package nozama.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import nozama.JPAUtil;
import nozama.model.Produto;
import nozama.model.Usuario;

public class UsuarioDAO {

	EntityManager manager;
	EntityTransaction tx;

	public void abrirTransacao() {
		manager = JPAUtil.getEntityManager();
		tx = manager.getTransaction();
		manager.getTransaction();
		tx.begin();

	}

	public void fecharTransacao() {
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

	public Usuario salvar(Usuario user) {
		abrirTransacao();

		manager.persist(user);

		fecharTransacao();

		return user;
	}

	public Usuario buscar(String nome) {
		

		return manager.find(Usuario.class, nome);

	}

	public void remover(Usuario user) {
		abrirTransacao();

		user = manager.find(Usuario.class, user.getNome());
		manager.remove(user);

		fecharTransacao();
	}
}
