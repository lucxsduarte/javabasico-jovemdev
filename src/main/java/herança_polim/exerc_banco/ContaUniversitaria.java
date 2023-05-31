package herança_polim.exerc_banco;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContaUniversitaria extends Conta{
	
	@Override
	public void depositar(int numero, int agencia, double quantidade) { 
		if(numero == this.getNumero() && agencia == this.getAgencia() && quantidade > 0 && quantidade <= 2000){
			if((quantidade + getSaldo() <= 2000)){
				this.setSaldo(getSaldo() + quantidade);
			}else {
				String ret = "Erro! Saldo máximo 2000";
			}
		}
	}
	
	@Override
	public void transferir(int numero, int agencia, double quantidade) {
		if(numero == this.getNumero() && agencia == this.getAgencia() && quantidade >0 && quantidade <= 2000) {
			if((quantidade + getSaldo() <= 2000)){
				this.setSaldo(getSaldo() + quantidade);
			} else {
				String ret = "Erro! Saldo máximo 2000";
			}
		}
	}
	
	public ContaUniversitaria(int numero, int agencia, String nome, double saldo) {
		super(numero, agencia, nome, saldo);
	}
}
