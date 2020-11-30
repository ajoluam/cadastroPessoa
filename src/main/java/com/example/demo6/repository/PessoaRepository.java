package com.example.demo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo6.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
