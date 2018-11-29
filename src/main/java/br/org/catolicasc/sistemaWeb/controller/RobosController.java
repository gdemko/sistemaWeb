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

import br.org.catolicasc.sistemaWeb.models.Robo;
import br.org.catolicasc.sistemaWeb.repository.RoboRepository;
import br.org.catolicasc.sistemaWeb.service.RoboService;

@Controller
@RequestMapping("/robos")
public class RobosController {
	
	@Autowired
	private RoboRepository roboRepository;
	
	@Autowired
	private RoboService service;

		@GetMapping("/cadastrar")
		public String form(Robo robo) {
			return "/robo/cadastro";
		}
		
		@PostMapping("/cadastrar")
		public String cadastrarRobos(Robo robo) {
			
			roboRepository.save(robo);
			
			return "redirect:/robos/cadastrar";
		}
		
		
		@GetMapping("/listar")
		public String listar(ModelMap model) {
			model.addAttribute("robos", roboRepository.findAll());
			return "/robo/lista";
		}	
		
		@ModelAttribute("robos")
		public List<Robo> listaDeRobos(){
			return roboRepository.findAll();
		}
		
		@GetMapping("/editar/{id}")
		public String editarForm(@PathVariable("id") Long id, ModelMap model) {
			model.addAttribute("robo", service.buscarPorId(id));
			return "/robo/cadastro";
		}
		
		@PostMapping("/editar")
		public String editarRobo(Robo robo) {
			
			service.editar(robo);
			
			return "redirect:/robos/listar";
		} 
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id") Long id, ModelMap model) {
			roboRepository.deleteById(id);
			model.addAttribute("success", "Robô excluido com sucesso");
			return "redirect:/robos/listar";
		}
	
}
