package herança_polim.exerc_banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Conta {
	protected int numero;
	protected int agencia;
	protected String nome;
	protected double saldo;
	
	
	public void depositar(double quantidade) { 
		this.saldo += quantidade;
		
	}
	
	public void sacar(double quantidade) {
		if(saldo >= quantidade && saldo > 0) {
			this.saldo -= quantidade;
		} else {
			this.saldo = getSaldo();
		}
		
	}
	
	public boolean transferir(double quantidade) {
		return quantidade <= saldo;
	}
}
