package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {
	
	@NonNull
	private String nome;
	
	private List<Disciplinas> nomeDisciplina = new ArrayList<Disciplinas>();
	
	private Map<Disciplinas, List<Double>> notas;
	
	public Alunos(String nome) {
		this.nome = nome;
		this.nomeDisciplina = new ArrayList<>();
		this.notas = new HashMap<>();
	}
	
	public void adicionaDisciplina(Disciplinas disciplina) {
		nomeDisciplina.add(disciplina);
		notas.put(disciplina, new ArrayList<>());
	}
	
	public List<Disciplinas> listDisciplinas(){
		return nomeDisciplina;
	}
	
	public Map<Disciplinas, List<Double>> getNotas() {
		return notas;
	}
	
	
	public void cadastrarNota(Disciplinas disciplina, double nota) {
		List<Double> notasDisciplina = notas.get(disciplina);
		notasDisciplina.add(nota);
	}
	
}
