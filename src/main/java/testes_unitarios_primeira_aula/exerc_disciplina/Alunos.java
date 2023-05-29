package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Alunos {

	private String nome;
	private List<Disciplinas> nomeDisciplina = new ArrayList<Disciplinas>();
}
