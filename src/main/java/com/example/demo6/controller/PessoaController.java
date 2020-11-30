package com.example.demo6.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo6.entity.Pessoa;
import com.example.demo6.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping(value = "/pessoa/lista")
	public List<Pessoa> Get() {
		return service.getAll();
	}

	@GetMapping(value = "/pessoa/{id}")
	public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id) {
		return service.getById(id);
	}

	@PostMapping(value = "/pessoa")
	public ResponseEntity<Pessoa> Post(@Valid @RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(service.savePessoa(pessoa), HttpStatus.CREATED);
	}

	@PutMapping(value = "/pessoa/{id}")
	public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa) {
		return service.putPessoa(id, newPessoa);
	}

	@DeleteMapping(value = "/pessoa/{id}")
	public ResponseEntity<Pessoa> Delete(@PathVariable(value = "id") long id) {
		return service.deletePessoa(id);
	}

}
