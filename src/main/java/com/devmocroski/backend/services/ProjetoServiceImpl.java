package com.devmocroski.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Projeto;
import com.devmocroski.backend.repository.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;
    
    @Override
    public Projeto inserir(Projeto projeto) throws Exception {
        return projetoRepository.saveAndFlush(projeto);
    }

    @Override
    public List<Projeto> listarTodos() throws Exception {
        List<Projeto> projetos = projetoRepository.findAll();
        if (projetos.isEmpty()) {
            throw new Exception("Não existem projetos cadastrados");
        }
        return projetos;
    }

    @Override
    public Projeto buscarPorId(Long id) throws Exception {
        Optional<Projeto> projetoEncontrado = projetoRepository.findById(id);
        if (!projetoEncontrado.isPresent()) {
            throw new Exception("Projeto com ID: " + id + " não encontrado");
        }
        return projetoEncontrado.get();
    }
    
    @Override
    public List<Projeto> buscarPorNome(String nome) throws Exception {
    	// TODO Auto-generated method stub
    	return null;
    }

    @Override
    public void deletar(Long id) throws Exception {
        Optional<Projeto> projetoExistente = projetoRepository.findById(id);
        if (!projetoExistente.isPresent()) {
            throw new Exception("Projeto com ID: " + id + " não encontrado");
        }
        projetoRepository.deleteById(id);
    }

    @Override
    public Projeto atualizar(Projeto projeto) throws Exception {
        Optional<Projeto> projetoExistente = projetoRepository.findById(projeto.getId());
        if (!projetoExistente.isPresent()) {
            throw new Exception("Projeto não encontrado");
        }
        return projetoRepository.saveAndFlush(projeto);
    }

}
