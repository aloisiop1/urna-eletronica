package br.com.etecmam.urnaeletronica.dmp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Cacheable(false)
public class Candidato {
	
	@Id 
	private int numero;

	private String nome;
	
	@Column(name = "partido" )
	private String sigla;
	
	private String foto;
	private int votos;
		
	public Candidato() {
	
	}	

	public Candidato(int numero, String nome, String sigla, String foto, int votos) {
		this.numero = numero;
		this.nome = nome;
		this.sigla = sigla;
		this.foto = foto;
		this.votos = votos;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	
}
