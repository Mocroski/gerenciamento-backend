package com.devmocroski.backend.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;
	private LocalDate dataConclusao;
	
	
	@ManyToOne
	private Projeto projeto;// Atributo para armazenar o projeto ao qual a tarefa está associada
	
	@ManyToOne// Indica que a tarefa tem muitos para um relacionamento com a entidade Usuario
	private Usuario usuarioResponsavel;// Atributo para armazenar o usuário responsável pela tarefa
}
