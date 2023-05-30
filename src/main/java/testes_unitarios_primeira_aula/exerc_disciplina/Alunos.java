package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {

	private String nome;
	
	//private List<Disciplinas> nomeDisciplina = new ArrayList<Disciplinas>();
	
	private double nota1;
	
	private double nota2;
	
	private double nota3;
}
