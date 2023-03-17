package com.devmocroski.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmocroski.backend.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	
	public List<Projeto> findByNome(String nome);
}
