package br.senai.sp.chamanoFilmes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// minimo para criar uma tabela no banco com hibernate

@Entity
@Table(name="tbl_filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String NomeFilme;
	private String Dubladores;
	private boolean viu;
	private String DtLancamento;
	private int nota;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DtLancamento == null) ? 0 : DtLancamento.hashCode());
		result = prime * result + ((Dubladores == null) ? 0 : Dubladores.hashCode());
		result = prime * result + ((NomeFilme == null) ? 0 : NomeFilme.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nota;
		result = prime * result + (viu ? 1231 : 1237);
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
		Filme other = (Filme) obj;
		if (DtLancamento == null) {
			if (other.DtLancamento != null)
				return false;
		} else if (!DtLancamento.equals(other.DtLancamento))
			return false;
		if (Dubladores == null) {
			if (other.Dubladores != null)
				return false;
		} else if (!Dubladores.equals(other.Dubladores))
			return false;
		if (NomeFilme == null) {
			if (other.NomeFilme != null)
				return false;
		} else if (!NomeFilme.equals(other.NomeFilme))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nota != other.nota)
			return false;
		if (viu != other.viu)
			return false;
		return true;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDubladores() {
		return Dubladores;
	}
	public void setDubladores(String dubladores) {
		Dubladores = dubladores;
	}
	public String getNomeFilme() {
		return NomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		NomeFilme = nomeFilme;
	}
	public boolean isViu() {
		return viu;
	}
	public void setViu(boolean viu) {
		this.viu = viu;
	}
	public String getDtLancamento() {
		return DtLancamento;
	}
	public void setDtLancamento(String dtLancamento) {
		DtLancamento = dtLancamento;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
