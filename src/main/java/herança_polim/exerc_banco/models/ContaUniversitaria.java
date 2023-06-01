package herança_polim.exerc_banco.models;

import lombok.Getter;

@Getter
public class ContaUniversitaria extends Conta{
	
	@Override
	public boolean depositar(double quantidade) { 
	
		if (saldo + quantidade <= 2000) {
			return super.depositar(quantidade);
		}
		return false;
	}
	
	
	public ContaUniversitaria(int numero, int agencia, String nome, double saldo) {
		super(numero, agencia, nome, saldo);
	}
}
