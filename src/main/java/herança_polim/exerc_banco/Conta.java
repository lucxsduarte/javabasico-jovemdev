package herança_polim.exerc_banco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
	protected int numero;
	protected int agencia;
	protected String nome;
	protected double saldo;
	
	
	public void depositar(int numero, int agencia, double quantidade) { 
		if(numero == this.getNumero() && agencia == this.getAgencia() && quantidade > 0){
			this.saldo += quantidade;
		}
	}
	
	public void saque(int numero, int agencia, double quantidade) {
		if(numero == this.getNumero() && agencia == this.getAgencia() && quantidade <= saldo) {
			if(getSaldo() > 0) {
				this.saldo -= quantidade;
			}
		
		}
	}
	
	public void transferir(int numero, int agencia, double quantidade) {
		if(numero == this.getNumero() && agencia == this.getAgencia() && quantidade <= saldo) {
			if(getSaldo() > 0) {
				this.saldo -= quantidade;
			}
		}
	}
}
