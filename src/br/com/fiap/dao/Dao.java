package br.com.fiap.dao;

import java.util.List;

public interface Dao<K, T> {
	void adicionar(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(K id);
}
