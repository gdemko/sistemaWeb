package br.org.catolicasc.sistemaWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.org.catolicasc.sistemaWeb.models.Robo;
import br.org.catolicasc.sistemaWeb.service.RoboService;

@Component
public class StringToRoboToConverter implements Converter<String, Robo>{
	
	@Autowired
	private RoboService service;

	@Override
	public Robo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id= Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
