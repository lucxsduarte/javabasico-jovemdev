package testes_unitarios_primeira_aula.exerc_disciplina.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Disciplinas {

	private String nomeDisciplina;
	private int cargaHoraria;
	private Professor professor;
}
