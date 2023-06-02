package refazer_exercicios.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {
	private String nome;
	private double saldoDevedor;
	
	public double pagarConta(double valor) {
		if(valor > 0 && valor <= saldoDevedor) {
			saldoDevedor = getSaldoDevedor() - valor;
		}
		return getSaldoDevedor();
	}
	
	public void adicionaDebito(double valor) {
		saldoDevedor = getSaldoDevedor() + valor;
	}
}
