package refazer_exercicios.banco.models;

import lombok.Getter;

@Getter
public class ContaUniversitaria extends Conta{

	public ContaUniversitaria(int numero, int agencia, String nomeCorrentista, double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}

	@Override
	public boolean depositar(double valor) {
		
		if(valor + saldo <= 2000) {
			return super.depositar(valor);
		}
		return false;
	}
}
