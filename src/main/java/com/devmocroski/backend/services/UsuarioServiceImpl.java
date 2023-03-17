package com.devmocroski.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Usuario;
import com.devmocroski.backend.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario inserir(Usuario objeto) throws Exception {
        // Verifica se o e-mail já está cadastrado
        Usuario usuarioExistente = usuarioRepository.findByEmail(objeto.getEmail());
        if (usuarioExistente != null) {
            throw new Exception("E-mail já cadastrado!");
        }
        
        // Salva o novo usuário
        Usuario novoUsuario = usuarioRepository.saveAndFlush(objeto);
        
        return novoUsuario;
    }
    
	@Override
	public List<Usuario> listarTodos() throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAll();
		if(usuarios.isEmpty()) {
			throw new Exception("Não existem usuarios cadastrados");
		}
		return usuarios;
	}	

	
    @Override
    public List<Usuario> buscarPorNome(String nome) throws Exception {
        List<Usuario> usuariosEncontrados = usuarioRepository.findByNome(nome);
        if(usuariosEncontrados.isEmpty()){
            throw new Exception("Nenhum usuário encontrado com o nome " + nome);
        }
        return usuariosEncontrados;
    }

    @Override
    public void deletar(Long id) throws Exception {
        // Busca o usuário a ser deletado pelo ID
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        // Verifica se o usuário existe na base de dados
        if(!usuarioExistente.isPresent()) {
            // Caso o usuário não exista, lança uma exceção informando o erro
            throw new Exception("Usuário com ID: " + id + " não encontrado");
        }
        // Se o usuário existe, deleta o registro na base de dados
        usuarioRepository.deleteById(id);
    }

	

	@Override
	public Usuario atualizar(Usuario objeto) throws Exception {
	    // Busca o usuário pelo ID
	    Optional<Usuario> usuarioExistente = usuarioRepository.findById(objeto.getId());

	    // Se o usuário não for encontrado, lança uma exceção
	    if (!usuarioExistente.isPresent()) {
	        throw new Exception("Usuário não encontrado");
	    }

	    // Obtém o usuário encontrado
	    Usuario usuario = usuarioExistente.get();

	    // Verifica se o nome foi informado na requisição e atualiza o nome do usuário
	    if (objeto.getNome() != null) {
	        usuario.setNome(objeto.getNome());
	    }

	    // Verifica se a senha foi informada na requisição e atualiza a senha do usuário
	    if (objeto.getSenha() != null) {
	        usuario.setSenha(objeto.getSenha());
	    }

	    // Verifica se o e-mail foi informado na requisição e atualiza o e-mail do usuário
	    if (objeto.getEmail() != null) {
	        usuario.setEmail(objeto.getEmail());
	    }

	    // Salva as alterações no banco de dados e retorna o usuário atualizado
	    return usuarioRepository.saveAndFlush(usuario);
	}


}


