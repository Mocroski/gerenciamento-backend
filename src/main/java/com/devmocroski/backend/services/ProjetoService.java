package com.devmocroski.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Projeto;

@Service
public interface ProjetoService {

	Projeto inserir(Projeto objeto) throws Exception;
	
	List<Projeto> buscarPorNome(String nome) throws Exception;
	
	Projeto buscarPorId(Long id) throws Exception;
	
	List<Projeto> listarTodos() throws Exception;
	
	void deletar(Long id) throws Exception;
	
	Projeto atualizar(Projeto objeto) throws Exception;
}
