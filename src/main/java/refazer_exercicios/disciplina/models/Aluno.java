package refazer_exercicios.disciplina.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Aluno {
	@NonNull
	private String nome;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private Map<Disciplina, double[]>notas = new HashMap<Disciplina, double[]>();
	
	public void adicionarDisciplina (Disciplina disciplina) {
		disciplinas.add(disciplina);
		notas.put(disciplina, new double[3]);
	}
	
	public void adicionarNotas(Disciplina disciplina, double[] notas) {
		this.notas.put(disciplina, new double[3]);
	}
	
	public double calcularMedia(Disciplina disciplina) {
		double[] notasDisciplinas = notas.get(disciplina);
		double soma = 0;
		for (double nota : notasDisciplinas) {
			soma += nota;
		}
		return soma / notasDisciplinas.length;
	}
}
