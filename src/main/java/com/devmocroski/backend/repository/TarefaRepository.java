package com.devmocroski.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmocroski.backend.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	List<Tarefa> findByUsuarioResponsavelId(Long idResponsavel);// Esse método retorna uma lista de tarefas que são atribuídas a um determinado usuário responsável. O ID do usuário é passado como parâmetro idResponsavel. Ele usa o padrão de nomenclatura de método do Spring Data JPA findBy<Propriedade>, seguido do nome da propriedade na entidade Tarefa que estamos buscando, UsuarioResponsavel, e Id, que representa o valor que estamos buscando.

	List<Tarefa> findByProjetoId(Long idProjeto);//Esse método retorna uma lista de tarefas que pertencem a um determinado projeto. O ID do projeto é passado como parâmetro idProjeto. Ele também segue o padrão de nomenclatura findBy<Propriedade><Operador>, onde Propriedade é o nome da propriedade na entidade Tarefa que estamos buscando (Projeto neste caso) e <Operador> pode ser Id ou qualquer outra operação suportada pelo Spring Data JPA. Neste caso, estamos usando Id como operador.

}
