package nozama.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import nozama.JPAUtil;
import nozama.model.Pessoa;

public class PessoaDAO {

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

	public Pessoa salvar(Pessoa pessoa) {
		abrirTransacao();

		manager.persist(pessoa);

		fecharTransacao();

		return pessoa;
	}

	public Pessoa buscar(String nome) {

		System.out.println("achei");
		
		return manager.find(Pessoa.class, nome);

	}
	
	public void remover(Pessoa pessoa) {
		abrirTransacao();
		
		pessoa = manager.find(Pessoa.class, pessoa.getId());
		manager.remove(pessoa);
		
		fecharTransacao();
	}

}
