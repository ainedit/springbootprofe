package es.cursojava.springbootprofe.services;

import org.springframework.stereotype.Service;

import es.cursojava.springbootprofe.model.CalculadoraDto;

@Service
public class CalculadoraService {
		
	public double calcular(CalculadoraDto calculadoraDto) {
		double resultado = 0;
		switch (calculadoraDto.getOperacion()) {
		case "sumar":
			resultado = calculadoraDto.getNum1() + calculadoraDto.getNum2();
			break;
		case "restar":
			resultado = calculadoraDto.getNum1() - calculadoraDto.getNum2();
			break;
		case "multiplicar":
			resultado = calculadoraDto.getNum1() * calculadoraDto.getNum2();
			break;
		case "dividir":
			if (calculadoraDto.getNum2() != 0) {
				resultado = calculadoraDto.getNum1() / calculadoraDto.getNum2();
			} else {
				throw new IllegalArgumentException("No se puede dividir por cero");
			}
			break;
		default:
			throw new IllegalArgumentException("Operación no válida");
		}
		return resultado;
	}
}
