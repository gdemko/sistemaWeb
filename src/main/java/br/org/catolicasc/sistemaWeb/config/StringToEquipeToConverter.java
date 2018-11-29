package br.org.catolicasc.sistemaWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.org.catolicasc.sistemaWeb.models.Equipe;
import br.org.catolicasc.sistemaWeb.service.EquipeService;

@Component
public class StringToEquipeToConverter implements Converter<String, Equipe>{
	
	@Autowired
	private EquipeService service;

	@Override
	public Equipe convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id= Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
