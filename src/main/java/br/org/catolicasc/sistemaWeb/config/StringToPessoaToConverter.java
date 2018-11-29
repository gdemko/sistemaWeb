package br.org.catolicasc.sistemaWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.org.catolicasc.sistemaWeb.models.Pessoa;
import br.org.catolicasc.sistemaWeb.service.PessoaService;

@Component
public class StringToPessoaToConverter implements Converter<String, Pessoa>{
	
	@Autowired
	private PessoaService service;

	@Override
	public Pessoa convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id= Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
