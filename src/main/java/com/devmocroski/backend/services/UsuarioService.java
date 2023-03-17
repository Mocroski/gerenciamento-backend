package com.devmocroski.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Usuario;

@Service
public interface UsuarioService {
	
	Usuario inserir(Usuario objeto) throws Exception;
	
	List<Usuario> buscarPorNome(String nome) throws Exception;
	
	List<Usuario> listarTodos() throws Exception;
	
	void deletar(Long id) throws Exception;
	
	Usuario atualizar(Usuario objeto) throws Exception;
}
