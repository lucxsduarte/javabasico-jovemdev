package refazer_exercicios.disciplina.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import refazer_exercicios.disciplina.enums.EnumFormacao;


@Getter
@AllArgsConstructor
public class Professor {

	private String nome;
	private EnumFormacao formação;
	
}
