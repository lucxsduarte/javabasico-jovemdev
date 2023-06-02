package refazer_exercicios.banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Conta {
	protected int numero;
	protected int agencia;
	protected String nomeCorrentista;
	protected double saldo;
	
	public boolean sacar(double valor) {
		if(valor <= saldo) {
			saldo = getSaldo() - valor;
			return true;
		}
		return false;
	}
	
	public boolean depositar(double valor) {
		if(valor > 0) {
			saldo = getSaldo() + valor;
			return true;
		}
		return false;
	}
	
	public boolean transferir(double valor, Conta contaDestino) {
		if(sacar(valor)) {
			if(contaDestino.depositar(valor)) {
				return true;
			}else {
				depositar(valor);
				return false;
			}
		}
		
		return false;
	}
	
	
}
