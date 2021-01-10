package main;

public class CalculadoraSalario {

	final double SALARIO_MINIMO = 1039.0;
	double desconto = 0;

	public double calculoINSS(double salarioBase) {
		if (salarioBase <= 1500.0) {
			desconto = salarioBase * 0.08;
		} else if (salarioBase > 1500.0 && salarioBase <= 4000.0){
			desconto = salarioBase * 0.09;
		} else {
			desconto = salarioBase * 0.11;
		}
		return salarioBase - desconto;
	}

	public double calculoIRPF(double salarioINSS) {
		if (salarioINSS <= 3000) {
			desconto = 0.0;
		} else if (salarioINSS > 3000 && salarioINSS <= 6000) {
			desconto = salarioINSS * 0.075;
		} else {
			desconto = salarioINSS * 0.15;
		}
		return salarioINSS - desconto;
	}
	
	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIO_MINIMO) {
			return 0;
		}
		
		double salarioINSS = calculoINSS(salarioBase);
		double salarioLiquido = calculoIRPF(salarioINSS);

		return Math.round(salarioLiquido);
	}
}
