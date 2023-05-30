package testes_unitarios_primeira_aula.exerc_medicamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Medicamento {

	private String nome;
	private EnumAdm adm;
}
