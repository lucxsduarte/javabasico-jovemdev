package herança_polim.exerc_banco.models;

import lombok.Getter;

@Getter
public class ContaUniversitaria extends Conta{
	
	@Override
	public void depositar(double quantidade) { 
	
		if (saldo + quantidade <= 2000) {
			saldo += quantidade;
		}else {
			saldo = getSaldo();
		}
	}
	
	
	public ContaUniversitaria(int numero, int agencia, String nome, double saldo) {
		super(numero, agencia, nome, saldo);
	}
}
