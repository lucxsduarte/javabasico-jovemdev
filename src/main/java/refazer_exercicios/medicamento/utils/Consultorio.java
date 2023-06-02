package refazer_exercicios.medicamento.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import refazer_exercicios.medicamento.models.Medicamento;
import refazer_exercicios.medicamento.models.Pessoa;

@Getter
public class Consultorio {
	private List<Pessoa> pessoas = new ArrayList<>();
	private List<Medicamento> medicamentos = new ArrayList<>();

	public void cadastraMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}
	
	public void cadastraPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public boolean existePessoa(Pessoa pessoa) {
		return pessoas.contains(pessoa);
	}
	
	public boolean existeMedicamentos(Medicamento medicamento) {
		return medicamentos.contains(medicamento);
	}
	
	public void prescreve(Medicamento medicamento, Pessoa pessoa) {
		if(existePessoa(pessoa) && existeMedicamentos(medicamento)) {
			pessoa.addMedicamento(medicamento);
		}
	}
	
}