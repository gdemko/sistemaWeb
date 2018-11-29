package br.org.catolicasc.sistemaWeb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.catolicasc.sistemaWeb.models.Equipe;
import br.org.catolicasc.sistemaWeb.repository.EquipeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Equipe")
@CrossOrigin(origins="*")
public class EquipeResource {

	@Autowired
	EquipeRepository equipeRepository;
	
	@GetMapping("/equipes")
	@ApiOperation(value="Retorna uma lista de Equipes.")
	public List<Equipe> listaEquipes(){
		return equipeRepository.findAll();
	}
	
	@GetMapping("/equipe/{id}")
	@ApiOperation(value="Retorna uma equipe unica.")
	public Equipe listaEquipeUnica(@PathVariable(value="id") long id){
		return equipeRepository.findById(id);
	}
	
	@PostMapping("/equipe")
	@ApiOperation(value="Salva uma equipe.")
	public Equipe salvaEquipe(@RequestBody Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	
	@DeleteMapping("/equipe")
	@ApiOperation(value="Deleta uma equipe.")
	public void deletaEquipe(@RequestBody Equipe equipe) {
		equipeRepository.delete(equipe);
	}
	
	@PutMapping("/equipe")
	@ApiOperation(value="Atualiza uma equipe.")
	public Equipe atualizaEquipe(@RequestBody Equipe equipe) {
		return equipeRepository.save(equipe);
	}
	
}