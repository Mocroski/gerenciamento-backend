package com.devmocroski.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmocroski.backend.entities.Notificacao;
import com.devmocroski.backend.repository.NotificacaoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Override
    public Notificacao inserir(Notificacao notificacao) throws Exception {
        return notificacaoRepository.save(notificacao);
    }

    @Override
    public List<Notificacao> buscarNotificacoesPorUsuario(Long idUsuario) throws Exception {
        return notificacaoRepository.findByUsuarioDestinatarioId(idUsuario);
    }

    @Override
    public List<Notificacao> listarTodas() throws Exception {
        return notificacaoRepository.findAll();
    }

    @Override
    public void deletarNotificacao(Long id) throws Exception {
        notificacaoRepository.deleteById(id);
    }

}
