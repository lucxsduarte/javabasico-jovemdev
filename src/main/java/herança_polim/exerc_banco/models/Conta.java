package herança_polim.exerc_banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Conta {
	protected int numero;
	protected int agencia;
	protected String nome;
	protected double saldo;
	
	
	public boolean depositar(double quantidade) { 
		if(quantidade > 0) {
			saldo = getSaldo() + quantidade;
			return true;
		} 
		return false;
	}
	
	public boolean sacar(double quantidade) {
		if(quantidade <= saldo) {
			saldo = getSaldo() - quantidade;
			return true;
		}
		return false;
	}
	
	public boolean transferir(double quantidade, Conta contaDestino) {
		if(sacar(quantidade)) {
			if(contaDestino.depositar(quantidade)) {
				return true;
			}else {
				depositar(quantidade);
				return false;
			}
		}
		return false;
	}
}
