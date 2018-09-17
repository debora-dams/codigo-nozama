package nozama.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import nozama.JPAUtil;
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

	public Produto buscar(String nome) {
		

		return manager.find(Produto.class, nome);

	}

	public void remover(Produto prod) {
		abrirTransacao();

		prod = manager.find(Produto.class, prod.getCodigoProd());
		manager.remove(prod);

		fecharTransacao();
	}

}
