package es.cursojava.springbootprofe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.cursojava.springbootprofe.model.StudentDto;
import es.cursojava.springbootprofe.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private final StudentService studentService; 
//	@GetMapping()
//	public String student() {
//		System.out.println("Student page accessed");
//		
//		return "student";
//	}
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping()
	public ModelAndView studentModelView() {
		System.out.println("Student page accessed");
		
		return new ModelAndView("student", "myStudent", new StudentDto("Juan"));
	}
	


//	@PostMapping("/save")
//	public String saveStudent(StudentDto student) {
//		System.out.println("Saving student: " + student.getNombre() + ", " + student.getEmail() + ", " + student.getEdad() + ", " + student.getCurso());
//		
//		// Aquí podrías agregar lógica para guardar el estudiante en una base de datos
//		System.out.println("Student saved successfully!");
//		return "student";
//	}
	
	@PostMapping("/save")
	public String saveStudent2(@ModelAttribute("myStudent")StudentDto student, Model model) {
		System.out.println("Saving student: " + student.getNombre() + ", " + student.getEmail() + ", " + student.getEdad() + ", " + student.getCurso());
		
		try {
			StudentDto createdStudent = studentService.create(student);
			model.addAttribute("mensaje", "Usuario añadido correctamente");
		} catch (IllegalArgumentException e) {
			model.addAttribute("mensaje", "Error: " + e.getMessage());
			return "student";
		}
		
		// Aquí podrías agregar lógica para guardar el estudiante en una base de datos
		System.out.println("Student saved successfully!");
		return "student";
	}
	
}







