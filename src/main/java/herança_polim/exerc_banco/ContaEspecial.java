package herança_polim.exerc_banco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContaEspecial extends Conta{
	
	private double limite;
	
	@Override
	public void saque(int numero, int agencia, double quantidade) {
		if(numero == this.getNumero() && agencia == this.getAgencia()) {
			if (quantidade <= getSaldo() || quantidade <= getLimite()) {
				if(getSaldo() > 0) {
					this.setSaldo(getSaldo() -  quantidade);
				}else if(quantidade <= getLimite()) {
					this.setLimite(getLimite() - quantidade);
				}
			}

		}
		
	}

	public ContaEspecial(int numero, int agencia, String nome, double saldo, double limite) {
		super(numero, agencia, nome, saldo);
		this.limite = limite;
		
	}
	
}
