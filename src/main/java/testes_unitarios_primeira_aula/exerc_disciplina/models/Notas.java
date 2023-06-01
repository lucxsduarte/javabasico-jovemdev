package testes_unitarios_primeira_aula.exerc_disciplina.models;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notas {
	private static double nota1;
	private static double nota2;
	private static double nota3;
	
	public static double adicionaNota() {
		double nota = Aleatorio(10);
		return nota;
	}
	
	public static double Aleatorio(double maximo){
		double numero = 0;
		Random rand = new Random();
		numero = rand.nextDouble(maximo);
		return numero;
	}
}
