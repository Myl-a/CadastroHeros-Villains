package com.ifce.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifce.br.model.Pessoa;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}