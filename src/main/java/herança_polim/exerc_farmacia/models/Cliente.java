package herança_polim.exerc_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cliente {
	private String nome;
	private double saldoDevedor;
	
	public void adicionaDivida(double valor	) {
		saldoDevedor += valor;
	}
	
	public void retiraDivida(double valor) {
		saldoDevedor -= valor;
	}
}
