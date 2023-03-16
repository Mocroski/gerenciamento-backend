package com.devmocroski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmocroski.backend.entities.Notificacao;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{

}
