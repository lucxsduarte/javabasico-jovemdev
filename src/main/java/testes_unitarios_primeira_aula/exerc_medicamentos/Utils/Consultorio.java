package testes_unitarios_primeira_aula.exerc_medicamentos.Utils;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import testes_unitarios_primeira_aula.exerc_medicamentos.models.Medicamento;
import testes_unitarios_primeira_aula.exerc_medicamentos.models.Pessoa;

@Getter
public class Consultorio {
	
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public Medicamento add (Medicamento m) {
		medicamentos.add(m);
		return m;
	}
	
	void cadastraMedicamento(Medicamento m) {
		medicamentos.add(m);
	}
	
	void cadastraPesoa(Pessoa p) {
		pessoas.add(p);
	}
	
	boolean existeMedicamento(Medicamento m) {
		return medicamentos.contains(m);
	}
	
	boolean existePessoa(Pessoa p) {
		return pessoas.contains(p);
	}
	
	void prescreveMedicamento(Pessoa p, Medicamento m) {
		if(existeMedicamento(m) && existePessoa(p)) {
		p.addMedicamento(m);
		}
	}
}
