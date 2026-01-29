package es.cursojava.springbootprofe.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.cursojava.springbootprofe.model.CaballoDto;
import es.cursojava.springbootprofe.services.CaballoService;

@Controller
//hace q la ruta sea relativa ,todas las demas rutas se iran concatenando
@RequestMapping("/carreracaballos")
public class CarreraController {
	private final CaballoService caballoService;

	public CarreraController(CaballoService caballoService) {
		this.caballoService = caballoService;
	}


	@GetMapping
	public String menuCarrera(Model model) {
		List<CaballoDto> caballos = caballoService.obtenerCaballosDisponibles();
		
		if (caballos.isEmpty()) {
			model.addAttribute("caballo", new CaballoDto());
			//return new ModelAndView("caballos/crearCaballo","caballo",new CaballoDto());
			return "caballos/crearCaballo"; // Redirige si no hay caballos
		}else {
			// Aquí podrías agregar los caballos al modelo si es necesario
			model.addAttribute("caballos", caballos);
			return "caballos/listaCaballos";
		}
		
		//return null; // Thymeleaf template del menú
	}
	
	@GetMapping("/nuevoCaballo")
	public String nuevoCaballo(Model model) {
		model.addAttribute("caballo", new CaballoDto());
		return "caballos/crearCaballo"; // Thymeleaf template para crear un nuevo caballo
	}

	@PostMapping("/guardarCaballo")
	public String guardarCaballo(@ModelAttribute CaballoDto caballoDto) {
		// Lógica para guardar el caballo usando el servicio
		// caballoService.guardarCaballo(caballo
		caballoService.guardarCaballo(caballoDto);
		
		return "redirect:/carreracaballos/listarCaballos"; // Redirige al menú de carreras después de guardar
		
	}
	
	@GetMapping("/listarCaballos")
	public String listaCaballos(Model model) {
		List<CaballoDto> caballos = caballoService.obtenerCaballosDisponibles();
		model.addAttribute("caballos", caballos);
		
		return "caballos/listaCaballos"; // Thymeleaf template para listar caballos
	}
	
	@GetMapping("/inicio")
	public String inicioCarrera(Model model) {
		
		CaballoDto caballo = caballoService.iniciarCarrera();
		
		model.addAttribute("caballoGanador", caballo);
		
		return "caballos/ganador"; // Thymeleaf template para listar caballos
	}

}






