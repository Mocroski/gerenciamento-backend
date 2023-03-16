package com.devmocroski.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmocroski.backend.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
