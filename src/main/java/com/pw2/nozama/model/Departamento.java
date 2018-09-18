package com.pw2.nozama.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*pagina sem tempo determinado de permanencia
 * decidir o que ira acontecer com essa pagina
*/

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String codigoDep;
	@Column
	private String nome;

	
	public Departamento(String nome, String codigoDep) {
		this.nome = nome;
		this.codigoDep = codigoDep;
	}

	public Departamento() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoDep() {
		return codigoDep;
	}

	public void setCodigoDep(String codigoDep) {
		this.codigoDep = codigoDep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDep == null) ? 0 : codigoDep.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Departamento other = (Departamento) obj;
		if (codigoDep == null) {
			if (other.codigoDep != null)
				return false;
		} else if (!codigoDep.equals(other.codigoDep))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
