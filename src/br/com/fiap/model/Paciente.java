package br.com.fiap.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PACIENTE", catalog = "EXERCICIO04", uniqueConstraints = { @UniqueConstraint(columnNames = { "CPF" }) })
public class Paciente implements Serializable {

	private static final long serialVersionUID = 7903448171974456852L;

	@Id
	@Column(name = "CPF", length = 11)
	private String cpf;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATANASC")
	private Calendar dataNasc;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="pacientes") 
	private Set<Agenda> agendas;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "paciente")
	private Set<Procedimento> procedimentos = new LinkedHashSet<>();

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "paciente")
	private Set<MatMed> matMeds = new LinkedHashSet<>();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Set<MatMed> getMatMeds() {
		return matMeds;
	}

	public void setMatMeds(Set<MatMed> matMeds) {
		this.matMeds = matMeds;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNasc=" + dateFormat.format(dataNasc.getTime())
				+ ", telefone=" + telefone + "]";
	}
}
