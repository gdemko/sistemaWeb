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

import br.org.catolicasc.sistemaWeb.models.Equipe;
import br.org.catolicasc.sistemaWeb.repository.EquipeRepository;
import br.org.catolicasc.sistemaWeb.service.EquipeService;

@Controller
@RequestMapping("/equipes")
public class EquipesController {

	@Autowired
	private EquipeRepository equipeRepository;
	
	@Autowired
	private EquipeService service;

	@GetMapping("/cadastrar")
	public String form(Equipe equipe) {
		return "/equipe/cadastro";
	}

	@PostMapping("/cadastrar")
	public String cadastrarEquipes(Equipe equipe) {

		equipeRepository.save(equipe);

		return "redirect:/equipes/cadastrar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("equipes", equipeRepository.findAll());
		return "/equipe/lista";
	}

	@ModelAttribute("equipes")
	public List<Equipe> listaDeEquipes() {
		return equipeRepository.findAll();
	}
	
	@GetMapping("/editar/{id}")
	public String editarForm(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("equipe", service.buscarPorId(id));
		return "/equipe/cadastro";
	}
	
	@PostMapping("/editar")
	public String editarEquipe(Equipe equipe) {
		
		service.editar(equipe);
		
		return "redirect:/equipes/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		equipeRepository.deleteById(id);
		model.addAttribute("success", "Equipe excluida com sucesso");
		return "redirect:/equipes/listar";
	}

}
