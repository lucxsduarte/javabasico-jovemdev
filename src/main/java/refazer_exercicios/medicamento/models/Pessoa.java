package refazer_exercicios.medicamento.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pessoa {
	@NonNull
	private String nome;
	@NonNull
	private String sintoma;
	private List<String> condicaoSaude = new ArrayList<>();
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	public boolean addMedicamento(Medicamento medicamento) {
		if(medicamento.isIndicado(sintoma) && !(medicamento.isContraIndicado(condicaoSaude))) {
			medicamentos.add(medicamento);
			return true;
		}
		return false;
	}
	
	public void addCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude.add(condicaoSaude);
	}
	
	
}