package testes_unitarios_primeira_aula.exerc_disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Professor {

	private String nome;
	private EnumFormacao formação;
	
	public cadastra() {
		nome = "Joao";
		
	}
	
}
