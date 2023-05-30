package testes_unitarios_primeira_aula.exerc_medicamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum EnumAdm {
	ORAL("Oral"),
	TÓPICO("Tópico"),
	INJETÁVEL("Injetável"),
	SUPOSITÓRIO("Supositório");
	
	private String descrição;
}
