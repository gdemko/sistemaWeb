package br.org.catolicasc.sistemaWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.sistemaWeb.models.Robo;
import br.org.catolicasc.sistemaWeb.repository.RoboRepository;

@Service
@Transactional(readOnly=false)
public class RoboService {
	
	@Autowired
	private RoboRepository repository;
	
	@Transactional(readOnly = true)
	public Robo buscarPorId(Long id) {
		Optional<Robo> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Robo editar(Robo robo) {
		return repository.saveAndFlush(robo);
	}

}

