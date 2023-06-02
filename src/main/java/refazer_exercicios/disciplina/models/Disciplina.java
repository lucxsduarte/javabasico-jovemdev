package refazer_exercicios.disciplina.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Disciplina {
	private String nome;
	private int cargaHoraria;
	private Professor professor;
}
