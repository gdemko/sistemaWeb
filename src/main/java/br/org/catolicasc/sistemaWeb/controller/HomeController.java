package br.org.catolicasc.sistemaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	@PostMapping("/logout")
	public String logout() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "/login";
	}

}
