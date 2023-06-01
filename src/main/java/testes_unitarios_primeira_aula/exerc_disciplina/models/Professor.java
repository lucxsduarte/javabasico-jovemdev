package testes_unitarios_primeira_aula.exerc_disciplina.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import testes_unitarios_primeira_aula.exerc_disciplina.enums.EnumFormacao;

@Getter
@Setter
@AllArgsConstructor
public class Professor {

	private String nome;
	private EnumFormacao formação;
//	private int id;
	
	
}
