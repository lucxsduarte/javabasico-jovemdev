package refazer_exercicios.banco.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import refazer_exercicios.banco.models.Conta;

@Getter
public class Caixa {
	private List<Conta> contas = new ArrayList<Conta>();
	
	public void cadastraConta(Conta conta) {
		contas.add(conta);
	}
	
	public boolean fazSaque(double valor, Conta conta) {
		return conta.sacar(valor);
	}
	
	public boolean fazDeposito(double valor, Conta conta) {
		return conta.depositar(valor);
	}
	
	public boolean fazTransferencia(double valor, Conta contaOrigem, Conta contaDestino) {
		return contaOrigem.transferir(valor, contaDestino);
	}
}
