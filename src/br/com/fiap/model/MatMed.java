package br.com.fiap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MATMED", catalog = "EXERCICIO04", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ID" } ) })
public class MatMed implements Serializable {

	private static final long serialVersionUID = -3150569694983736292L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private Long id;
	
	@Column(name = "DESCRICAO", length = 45)
	private String descricao;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@Column(name = "FABRICANTE", length = 45)
	private String fabricante;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumns({@JoinColumn(name="CPFPAC",referencedColumnName="CPF")})
	private Paciente paciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "MatMed [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", fabricante=" + fabricante
				+ "]";
	}
}
