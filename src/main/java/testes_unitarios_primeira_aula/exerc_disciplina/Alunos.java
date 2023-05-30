package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Alunos {
	@NonNull
	private String nome;
	
	private List<Disciplinas> nomeDisciplina = new ArrayList<Disciplinas>();
	
	
	
	public void adicionaDisciplina(Disciplinas disciplina) {
		nomeDisciplina.add(disciplina);
	}
	
	public List<Disciplinas> listDisciplinas(){
		return nomeDisciplina;
	}
	
	public void informaNotas(Disciplinas disciplina) {
		double nota1 = Notas.adicionaNota();
		double nota2 = Notas.adicionaNota();
		double nota3 = Notas.adicionaNota();
	}
	
}
