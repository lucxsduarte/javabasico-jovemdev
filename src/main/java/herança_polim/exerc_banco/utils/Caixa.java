package herança_polim.exerc_banco.utils;

import java.util.ArrayList;
import java.util.List;

import herança_polim.exerc_banco.models.Conta;
import lombok.Getter;

@Getter
public class Caixa {

	List<Conta> contas = new ArrayList<Conta>();

	public void cadastraConta(Conta c) {
		contas.add(c);
	}

	public boolean fazDeposito(double quantidade, Conta c) {
		return c.depositar(quantidade);
	}

	public boolean fazSaque(double quantidade, Conta c) {
		return c.sacar(quantidade);
	}
	
	public boolean fazTransferencia(double quantidade, Conta contaOrigem, Conta contaDestino) {
		return contaOrigem.transferir(quantidade, contaDestino);
	}
}
