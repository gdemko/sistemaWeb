package br.org.catolicasc.sistemaWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.sistemaWeb.models.Equipe;
import br.org.catolicasc.sistemaWeb.repository.EquipeRepository;

@Service
@Transactional(readOnly=false)
public class EquipeService {
	
	@Autowired
	private EquipeRepository repository;
	
	@Transactional(readOnly = true)
	public Equipe buscarPorId(Long id) {
		Optional<Equipe> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Equipe editar(Equipe equipe) {
		return repository.saveAndFlush(equipe);
	}
	
}
