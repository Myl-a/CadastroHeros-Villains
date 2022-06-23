package com.ifce.br.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifce.br.model.Pessoa;
import com.ifce.br.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public void cadastrarPessoa(Pessoa pessoa) {
	pessoaRepo.save(pessoa);
	}
	public List<Pessoa> listarPessoa() {
		return pessoaRepo.findAll() ;
	}

	public Optional<Pessoa> retornarPeloCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	
}
