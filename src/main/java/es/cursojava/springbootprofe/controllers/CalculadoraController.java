package es.cursojava.springbootprofe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.cursojava.springbootprofe.model.CalculadoraDto;
import es.cursojava.springbootprofe.services.CalculadoraService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@Autowired
	private CalculadoraService calculadoraService;
	
	@GetMapping()
	public String calculadora(Model model, HttpServletRequest request) {
		double num1 = request.getParameter("num1") != null ? Double.parseDouble(request.getParameter("num1")) : 0;
		double num2 = request.getParameter("num2") != null ? Double.parseDouble(request.getParameter("num2")) : 0;
		String operacion = request.getParameter("operacion") != null ? request.getParameter("operacion") : "sumar";
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("operacion: " + operacion);
		
		CalculadoraDto calculadoraDto = new CalculadoraDto(num1, num2, operacion);
		double resultado = calculadoraService.calcular(calculadoraDto);
		
		
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
	@GetMapping("/{xxx}.do") 
	public String operar(ModelMap model,
			@PathVariable("xxx") String operacion,
			@RequestParam("num1") int num1, 
			@RequestParam("num2") int num2
			) {
		
		
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("operacion: " + operacion);
		
		CalculadoraDto calculadoraDto = new CalculadoraDto(num1, num2, operacion);
		double resultado = calculadoraService.calcular(calculadoraDto);
		
		
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
	@GetMapping("/operardto")
	public String operarDto(ModelMap model, CalculadoraDto calculadoraDto ) {
		System.out.println("num1: " + calculadoraDto.getNum1());
		System.out.println("num2: " + calculadoraDto.getNum2());
		System.out.println("operacion: " + calculadoraDto.getOperacion());
		
		double resultado = calculadoraService.calcular(calculadoraDto);
		
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
	@PostMapping("/operarpost")
	public String operarpost(ModelMap model, CalculadoraDto calculadoraDto ) {
		
		return operarDto(model, calculadoraDto);
	}
}





