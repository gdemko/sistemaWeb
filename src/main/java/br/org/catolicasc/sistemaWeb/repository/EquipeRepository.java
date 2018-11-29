package br.org.catolicasc.sistemaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.catolicasc.sistemaWeb.models.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long>{
	Equipe findById(long id);

}

