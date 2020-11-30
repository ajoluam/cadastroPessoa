package com.example.demo6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo6.entity.Pessoa;
import com.example.demo6.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository _pessoaRepository;

	public List<Pessoa> getAll() {
		return _pessoaRepository.findAll();
	}
	
	public ResponseEntity<Pessoa> getById(long id) {
		Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
		if (pessoa.isPresent())
			return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public Pessoa savePessoa(Pessoa pessoa) {
		return _pessoaRepository.save(pessoa);
	}
	
	public ResponseEntity<Pessoa> putPessoa(long id, Pessoa newPessoa) {
		Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
		if (oldPessoa.isPresent()) {
			Pessoa pessoa = oldPessoa.get();
			pessoa.setNome(newPessoa.getNome());
			pessoa.setSobrenome(newPessoa.getSobrenome());
			pessoa.setEmail(newPessoa.getEmail());
			_pessoaRepository.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Pessoa> deletePessoa(long id) {
		Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			_pessoaRepository.delete(pessoa.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
