package testes_unitarios_primeira_aula.exerc_medicamentos;

import java.util.ArrayList;
import java.util.List;

public class Util {
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	
	public Medicamento add (Medicamento m) {
		medicamentos.add(m);
		return m;
	}
}
