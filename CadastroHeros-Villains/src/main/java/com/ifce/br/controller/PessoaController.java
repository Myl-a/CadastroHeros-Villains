package com.ifce.br.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	@RequestMapping("/herovillain/salvar")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaService.cadastrarPessoa(pessoa);
		ModelAndView mv = new ModelAndView("redirect:herovillain/listar");
		return mv;
	}
	@GetMapping("herovillain/listar")
	public ModelAndView listarPessoa() {
	
		List<Pessoa> pessoas  = pessoaService.listarPessoa();
		ModelAndView mv = new ModelAndView("listagem-pessoa");
		mv.addObject("listaPessoas", pessoas);
		return mv;

}
	@GetMapping("/herovillain/excluir/{codigo}")
	public ModelAndView excluirPessoaPorId(@PathVariable Long codigo) {
		pessoaService.excluirPessoaPorId(codigo);
		
		ModelAndView mv  = new ModelAndView("redirect:herovillain/listar");
		return mv;
	}
	@RequestMapping("/herovillain/atualizar/{codigo}")
	public ModelAndView atualizarPessoaPorId(@PathVariable Long codigo) {
		Optional<Pessoa> pessoa = pessoaService.buscarPorId(codigo);
		ModelAndView mv = new ModelAndView("formulario");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
}
