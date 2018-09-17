package nozama.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "codigoprod")
	private List<Produto> produtos = new ArrayList<>();
	@Column(name = "total_de_compras")
	private Double total;
	
	public Carrinho() {
		
	}

	public void adiciona(Produto produto) {
		produtos.add(produto);
		total += produto.getPreco() * produto.getQuantidade();
	}

	public void remove(int indiceItem) {
		Produto removido = produtos.remove(indiceItem);
		total -= removido.getPreco() * removido.getQuantidade();
	}

	public Integer getTotaldeProdutos() {
		return produtos.size();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> itens) {
		this.produtos = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

}
