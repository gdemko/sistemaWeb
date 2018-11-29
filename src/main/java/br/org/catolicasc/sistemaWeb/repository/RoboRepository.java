package br.org.catolicasc.sistemaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.catolicasc.sistemaWeb.models.Robo;

public interface RoboRepository extends JpaRepository<Robo, Long>{
	Robo findById(long id);
}