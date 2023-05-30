package testes_unitarios_primeira_aula.exerc_medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import testes_unitarios_primeira_aula.exerc_medicamentos.EnumAdm;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
	
	@NonNull
	private String nome;
	@NonNull
	private EnumAdm adm;
	private List<String> contraIndicacoes = new ArrayList<String>();
	private List<String> indicacoes = new ArrayList<String>();
	
	public boolean isIndicado(String sintoma) {
		return indicacoes.contains(sintoma);
	}
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
		return condicaoSaude.stream()
				.anyMatch(contraIndicacoes::contains);
	}
	
	public void addIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}
	
	public void addContraIndicacoes(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}
}
