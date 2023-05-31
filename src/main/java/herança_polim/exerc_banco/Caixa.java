package herança_polim.exerc_banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {
	
	List<Conta> contas = new ArrayList<Conta>();
	
	void cadastraConta(Conta c){
		contas.add(c);
	}
	
	boolean existeConta(Conta c) {
		return contas.contains(c);
	}
	
	void fazDepósito(Conta c, double quantidade) {
		if(existeConta(c)) {
			c.depositar(c.getNumero(), c.getAgencia(), quantidade);
		}
	}
	
	void fazSaque(Conta c, double quantidade) {
		if(existeConta(c)) {
			c.saque(c.getNumero(), c.getAgencia(), quantidade);
		}
	}
}
