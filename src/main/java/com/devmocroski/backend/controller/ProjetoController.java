package com.devmocroski.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmocroski.backend.entities.Projeto;
import com.devmocroski.backend.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	 @PostMapping
	    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
	        try {
	            Projeto novoProjeto = projetoService.inserir(projeto);
	            return new ResponseEntity<>(novoProjeto, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 @GetMapping
	    public ResponseEntity<List<Projeto>> listarProjetos() {
	        try {
	            List<Projeto> projetos = projetoService.listarTodos();
	            return new ResponseEntity<>(projetos, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	  @GetMapping("/{id}")
	    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
	        try {
	            Projeto projeto = projetoService.buscarPorId(id);
	            return ResponseEntity.ok(projeto);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
}
