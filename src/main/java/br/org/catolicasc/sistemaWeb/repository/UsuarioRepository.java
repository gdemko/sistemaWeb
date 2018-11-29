package br.org.catolicasc.sistemaWeb.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.catolicasc.sistemaWeb.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
