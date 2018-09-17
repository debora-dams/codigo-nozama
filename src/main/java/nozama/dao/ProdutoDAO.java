package nozama.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import nozama.JPAUtil;
import nozama.model.Pessoa;
import nozama.model.Produto;

public class ProdutoDAO {

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

	public Produto salvar(Produto produto) {
		abrirTransacao();

		manager.persist(produto);

		fecharTransacao();

		return produto;
	}

}
