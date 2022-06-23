package com.ifce.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifce.br.model.Pessoa;
import com.ifce.br.service.PessoaService;

@Controller
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;
	@GetMapping("/olaMundo")
	public String olaMundo() {
		return "ola-mundo";
	}
	@GetMapping("herovillain/formulario")
	public String formulario() {
		return "formulario";
	}
	@GetMapping("herovillain/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaService.cadastrarPessoa(pessoa);
		return "sucesso";
	}

}
