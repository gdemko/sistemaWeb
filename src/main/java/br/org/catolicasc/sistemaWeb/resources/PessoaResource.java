package br.org.catolicasc.sistemaWeb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.catolicasc.sistemaWeb.models.Pessoa;
import br.org.catolicasc.sistemaWeb.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Controller
@RequestMapping("/api")
@Api(value="API REST Pessoa")
@CrossOrigin(origins="*")
public class PessoaResource {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/cadastrarPessoa")
	public String form(){
		return "pessoa/formPessoa";
	}
	
	@GetMapping("/pessoas")
	@ApiOperation(value="Retorna uma lista de Pessoas.")
	public List<Pessoa> listaPessoas(){
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	@ApiOperation(value="Retorna um pessoa unica.")
	public Pessoa listaPessoaUnica(@PathVariable(value="id") long id){
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	@ApiOperation(value="Salva uma pessoa.")
	public Pessoa salvaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	@ApiOperation(value="Deleta uma pessoa.")
	public void deletaPessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoa")
	@ApiOperation(value="Atualiza uma pessoa.")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
}
