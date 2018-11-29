package br.org.catolicasc.sistemaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.catolicasc.sistemaWeb.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Pessoa findById(long id);

}
