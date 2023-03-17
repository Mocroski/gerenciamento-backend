package com.devmocroski.backend.services;

import java.util.List;

import com.devmocroski.backend.entities.Notificacao;

public interface NotificacaoService {

    Notificacao inserir(Notificacao notificacao) throws Exception;

    List<Notificacao> buscarNotificacoesPorUsuario(Long idUsuario) throws Exception;

    List<Notificacao> listarTodas() throws Exception;

    void deletarNotificacao(Long id) throws Exception;

}
