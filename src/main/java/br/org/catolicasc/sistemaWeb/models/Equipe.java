package br.org.catolicasc.sistemaWeb.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_EQUIPE")
public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	private String nome;
	private String entidadeVinculada;
	private String endereco;
	private String email;
	private String telefone;
	private String cnpj;
	private String linkRedesSociais;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEntidadeVinculada() {
		return entidadeVinculada;
	}
	public void setEntidadeVinculada(String entidadeVinculada) {
		this.entidadeVinculada = entidadeVinculada;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getLinkRedesSociais() {
		return linkRedesSociais;
	}
	public void setLinkRedesSociais(String linkRedesSociais) {
		this.linkRedesSociais = linkRedesSociais;
	}
	
}
