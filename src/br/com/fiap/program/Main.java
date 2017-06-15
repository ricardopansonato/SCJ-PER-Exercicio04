package br.com.fiap.program;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.fiap.dao.impl.GenericDao;
import br.com.fiap.model.Agenda;
import br.com.fiap.model.MatMed;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Procedimento;

public class Main {
	
	public static void main(String[] args) {
		GenericDao<String, Paciente> pacienteDao = new GenericDao<>(Paciente.class);
		GenericDao<Long, Agenda> agendaDao = new GenericDao<>(Agenda.class);
		
		for (int i = 1; i < 20; i++) {
			Paciente paciente = new Paciente();
			paciente.setCpf("123" + Integer.toString(i));
			paciente.setDataNasc(Calendar.getInstance());
			paciente.setNome("Teste");
			paciente.setTelefone("(12)34567890");
			MatMed matMed = new MatMed();
			matMed.setDescricao("Teste Med");
			matMed.setPaciente(paciente);
			matMed.setFabricante("Fabr Med");
			matMed.setPreco(1234.4d);
			Set<MatMed> matMeds = new HashSet<>();
			matMeds.add(matMed);
			paciente.setMatMeds(matMeds);
			Procedimento procedimento = new Procedimento();
			procedimento.setDescricao("Teste Proc");
			procedimento.setPaciente(paciente);
			procedimento.setPreco(1234.3d);
			Set<Procedimento> procedimentos = new HashSet<>();
			procedimentos.add(procedimento);
			paciente.setProcedimentos(procedimentos);
			pacienteDao.adicionar(paciente);
		}
		
		for (int j = 1; j < 10; j++) {
			Agenda agenda = new Agenda();
			agenda.setData(Calendar.getInstance());
			agenda.setHora(Calendar.getInstance());
			agenda.setDescricao("Teste " + j);
			agendaDao.adicionar(agenda);
			
			Agenda a = agendaDao.buscar(new Long(j));
			System.out.println(a);
			Paciente p = pacienteDao.buscar("123" + j);
			Set<Paciente> pacientes = new HashSet<>();
			pacientes.add(p);
			Set<Agenda> agendas = new HashSet<>();
			agendas.add(a);
			p.setAgendas(agendas);
			a.setPacientes(pacientes);
			agendaDao.atualizar(a);
		}
		
		
		pacienteDao.listar().forEach(p -> {
			System.out.println(p);
			
			p.getAgendas().forEach(a -> {
				System.out.println(a);
			});
			
			p.getProcedimentos().forEach(pr -> {
				System.out.println(pr);
			});
			
			p.getMatMeds().forEach(mm -> {
				System.out.println(mm);
			});
		});
		
		agendaDao.remover(agendaDao.buscar(new Long(1)));
		agendaDao.listar().forEach(a -> {
			System.out.println(a);
		});
	}
	
}
