package br.com.fiap.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AGENDA", catalog = "EXERCICIO04", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Agenda implements Serializable {

	private static final long serialVersionUID = -2546797637816796856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA")
	private Calendar data;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HORA")
	private Calendar hora;

	@Column(name = "DESCRICAO", length = 45)
	private String descricao;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AGENDA_PACIENTE", catalog = "EXERCICIO04", joinColumns = {
			@JoinColumn(name = "AGENDA_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PACIENTE_CPF", nullable = false, updatable = false) })
	private Set<Paciente> pacientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("hh:mm");
		return "Agenda [id=" + id + ", data=" + dateFormat.format(data.getTime()) + ", hora="
				+ hourFormat.format(hora.getTime()) + ", descricao=" + descricao + "]";
	}
}
