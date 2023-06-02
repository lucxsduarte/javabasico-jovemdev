package refazer_exercicios.medicamento.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import refazer_exercicios.medicamento.enums.EnumAdm;

@Getter
@RequiredArgsConstructor
public class Medicamento {
	@NonNull
	private String nome;
	@NonNull
	private EnumAdm adm;
	private List<String> contraIndicacoes = new ArrayList<String>();
	private List<String> indicado = new ArrayList<String>();
	
	public boolean isIndicado(String sintoma) {
		return indicado.contains(sintoma);
	}
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
		return contraIndicacoes.stream().anyMatch(condicaoSaude::contains);
	}
	
	public void addIndicacao(String sintoma) {
		indicado.add(sintoma);
	}
	
	public void addContraIndicacao(String condicaoSaude) {
		contraIndicacoes.add(condicaoSaude);
	}
	
}
