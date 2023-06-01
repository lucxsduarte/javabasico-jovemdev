package herança_polim.exerc_banco.utils;

import java.util.ArrayList;
import java.util.List;

import herança_polim.exerc_banco.models.Conta;
import herança_polim.exerc_banco.models.ContaEspecial;
import herança_polim.exerc_banco.models.ContaUniversitaria;
import lombok.Getter;

@Getter
public class Caixa {

	List<Conta> contas = new ArrayList<Conta>();

	void cadastraConta(Conta c) {
		contas.add(c);
	}

	void fazDepósito(Conta c, double quantidade) {
		if (c instanceof ContaUniversitaria) {
			c.depositar(quantidade);
		} else {
			c.depositar(quantidade);
		}
	}

	void fazSaque(Conta c, double quantidade) {
		if (c instanceof ContaEspecial) {
			c.sacar(quantidade);
		} else {
			c.sacar(quantidade);
		}
	}

	void fazTransferencia(Conta contaOrigem, Conta contaDestino, double quantidade) {
		if(contaOrigem.transferir(quantidade) && !(contaDestino instanceof ContaUniversitaria)) {
			contaOrigem.sacar(quantidade);
			contaDestino.depositar(quantidade);
			
		} else if (contaOrigem.transferir(quantidade) && contaDestino instanceof ContaUniversitaria) {
			if(contaDestino.getSaldo() + quantidade < 2000) {
				contaOrigem.sacar(quantidade);
				contaDestino.depositar(quantidade);
			}
			
		}
	}
}
