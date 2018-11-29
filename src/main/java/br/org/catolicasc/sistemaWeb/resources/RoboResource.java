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

import br.org.catolicasc.sistemaWeb.models.Robo;
import br.org.catolicasc.sistemaWeb.repository.RoboRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Robo")
@CrossOrigin(origins="*")
public class RoboResource {

	@Autowired
	RoboRepository roboRepository;
	
	@GetMapping("/robos")
	@ApiOperation(value="Retorna uma lista de Robos.")
	public List<Robo> listaRobos(){
		return roboRepository.findAll();
	}
	
	@GetMapping("/robo/{id}")
	@ApiOperation(value="Retorna um robo unico.")
	public Robo listaRoboUnico(@PathVariable(value="id") long id){
		return roboRepository.findById(id);
	}
	
	@PostMapping("/robo")
	@ApiOperation(value="Salva um robo.")
	public Robo salvaRobo(@RequestBody Robo robo) {
		return roboRepository.save(robo);
	}
	
	@DeleteMapping("/robo")
	@ApiOperation(value="Deleta um robo.")
	public void deletaRobo(@RequestBody Robo robo) {
		roboRepository.delete(robo);
	}
	
	@PutMapping("/robo")
	@ApiOperation(value="Atualiza um robo.")
	public Robo atualizaRobo(@RequestBody Robo robo) {
		return roboRepository.save(robo);
	}
	
}
