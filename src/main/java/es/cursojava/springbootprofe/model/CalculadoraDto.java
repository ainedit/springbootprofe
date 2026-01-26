package es.cursojava.springbootprofe.model;

public class CalculadoraDto {
	public double num1;
	public double num2;
	public String operacion;
	public CalculadoraDto(double num1, double num2, String operacion) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.operacion = operacion;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
}
