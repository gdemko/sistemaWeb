package br.org.catolicasc.sistemaWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.catolicasc.sistemaWeb.models.Pessoa;
import br.org.catolicasc.sistemaWeb.repository.PessoaRepository;
import br.org.catolicasc.sistemaWeb.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoasController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaService service;
		
		@GetMapping("/cadastrar")
		public String form(Pessoa pessoa) {
			return "/pessoa/cadastro";
		}
		
		@PostMapping("/salvar")
		public String cadastrarPessoas(Pessoa pessoa) {
			
			pessoaService.salvar(pessoa);		
			return "redirect:/pessoas/cadastrar";
		}
		
		@GetMapping("/listar")
		public String listar(ModelMap model) {
			model.addAttribute("pessoas", pessoaRepository.findAll());
			return "/pessoa/lista";
		}
		
		@ModelAttribute("pessoas")
		public List<Pessoa> listaDePessoas(){
			return pessoaRepository.findAll();
		}
		
		@GetMapping("/editar/{id}")
		public String editarForm(@PathVariable("id") Long id, ModelMap model) {
			model.addAttribute("pessoa", service.buscarPorId(id));
			return "/pessoa/cadastro";
		}
		
		@PostMapping("/editar")
		public String editarPessoa(Pessoa pessoa) {
			
			service.editar(pessoa);
			
			return "redirect:/pessoas/listar";
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id") Long id, ModelMap model) {
			pessoaRepository.deleteById(id);
			model.addAttribute("success", "Pessoa excluida com sucesso");
			return "redirect:/pessoas/listar";
		}
	
}
