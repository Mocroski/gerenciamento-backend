package com.devmocroski.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Tarefa;
import com.devmocroski.backend.repository.TarefaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TarefaServiceImpl implements TarefaService{

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public Tarefa inserir(Tarefa tarefa) throws Exception {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa atualizar(Tarefa tarefa) throws Exception {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> buscarTarefasPorProjeto(Long idProjeto) throws Exception {
        return tarefaRepository.findByProjetoId(idProjeto);
    }

    @Override
    public List<Tarefa> buscarTarefasPorResponsavel(Long idResponsavel) throws Exception {
        return tarefaRepository.findByUsuarioResponsavelId(idResponsavel);
    }

    @Override
    public void deletarTarefa(Long id) throws Exception {
        tarefaRepository.deleteById(id);
    }
}
