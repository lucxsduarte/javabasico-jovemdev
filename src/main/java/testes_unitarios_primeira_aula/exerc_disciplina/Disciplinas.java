package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Disciplinas {

	private String nomeDisciplina;
	private int cargaHoraria;
	private List<Professor> professorLeciona = new ArrayList<Professor>();
}
