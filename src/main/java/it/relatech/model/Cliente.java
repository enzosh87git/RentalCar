package it.relatech.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String cognome;
	
	@OneToMany(mappedBy="cliente")
	private List<Noleggio> listNoleggi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Noleggio> getListNoleggi() {
		return listNoleggi;
	}

	public void setListNoleggi(List<Noleggio> listNoleggi) {
		this.listNoleggi = listNoleggi;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", listNoleggi=" + listNoleggi + "]";
	}
}
