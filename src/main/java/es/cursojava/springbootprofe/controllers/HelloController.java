package es.cursojava.springbootprofe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	//@GetMapping("/welcome")
	public String welcome() {
		System.out.println("Welcome to Spring Boot!");
		return "welcome";
	}

	@GetMapping("/test")
	public String test(Model model, HttpServletRequest request) {
		request.getParameter("");
		model.addAttribute("mensaje", "Hello from Spring Boot!");
		model.addAttribute("numero", 6);
		return "test";
	}
	
}
