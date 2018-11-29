package br.org.catolicasc.sistemaWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.org.catolicasc.sistemaWeb.models.Pessoa;
import br.org.catolicasc.sistemaWeb.repository.PessoaRepository;

@Service
@Transactional(readOnly=false)
public class PessoaService {	
	
	@Autowired
	private PessoaRepository repository;
	
	@Transactional(readOnly = true)
	public Pessoa buscarPorId(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Pessoa editar(Pessoa pessoa) {
		return repository.saveAndFlush(pessoa);
	}
	
	
	public Pessoa salvar(Pessoa pessoa) {
		return repository.save(pessoa);
	}

}
