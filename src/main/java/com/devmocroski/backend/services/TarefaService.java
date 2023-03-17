package com.devmocroski.backend.services;

import java.util.List;

import com.devmocroski.backend.entities.Tarefa;

public interface TarefaService {

	 	Tarefa inserir(Tarefa objeto) throws Exception;
	    
	    Tarefa atualizar(Tarefa objeto) throws Exception;
	    
	    List<Tarefa> buscarTarefasPorProjeto(Long idProjeto) throws Exception;
	    
	    List<Tarefa> buscarTarefasPorResponsavel(Long idResponsavel) throws Exception;
	    
	    void deletarTarefa(Long id) throws Exception;
}
