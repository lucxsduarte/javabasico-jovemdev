package herança_polim.exerc_banco.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import herança_polim.exerc_banco.models.Conta;
import herança_polim.exerc_banco.models.ContaEspecial;
import herança_polim.exerc_banco.models.ContaUniversitaria;

public class CaixaTest {

	Caixa caixa = new Caixa();

	@BeforeEach
	void setup() {
		caixa.getContas().clear();
		Conta c1 = new Conta(1, 100, "Pessoa 1", 5500);
		Conta c2 = new ContaEspecial(2, 100, "Pessoa 2", 1500, 500);
		Conta c3 = new ContaUniversitaria(3, 100, "Pessoa 3", 1400);
		Conta c4 = new Conta(1, 100, "Pessoa 4", 1290);

		caixa.cadastraConta(c1);
		caixa.cadastraConta(c2);
		caixa.cadastraConta(c3);
		caixa.cadastraConta(c4);
	}

	@Test
	@DisplayName("Testa cadastro de Conta")
	void testaCadastroConta() {
		Conta c5 = new Conta(4, 100, "Pessoa 5", 6000);
		caixa.cadastraConta(c5);
		assertEquals(5, caixa.getContas().size());
	}

	@Test
	@DisplayName("Testa depósito conta corrente")
	void testaDeposito() {
		caixa.fazDepósito(caixa.contas.get(0), 500);
		assertEquals(6000, caixa.contas.get(0).getSaldo());
	}

	@Test
	@DisplayName("Testa depósito conta universitaria")
	void testaDepositoUniversitaria() {
		caixa.fazDepósito(caixa.contas.get(2), 700);
		assertEquals(1400, caixa.contas.get(2).getSaldo());
	}

	@Test
	@DisplayName("Testa saque conta corrente")
	void testaSaque() {
		caixa.fazSaque(caixa.contas.get(0), 500);
		assertEquals(5000, caixa.contas.get(0).getSaldo());
	}

	@Test
	@DisplayName("Testa saque conta especial")
	void testaSaqueEspecial() {
		if (caixa.contas.get(1) instanceof ContaEspecial) {
			Conta c = (ContaEspecial) caixa.getContas().get(1);
			caixa.fazSaque(c, 1900);
			assertEquals(-400, caixa.contas.get(1).getSaldo());
		}
	}

	@Test
	@DisplayName("Testa transferencia")
	void testaTransf() {
		Conta contaOrigem = caixa.contas.get(0);
		Conta contaDestino = caixa.contas.get(3);

		caixa.fazTransferencia(contaOrigem, contaDestino, 400);
		assertEquals(5100, caixa.contas.get(0).getSaldo());
		assertEquals(1690, caixa.contas.get(3).getSaldo());
	}

	@Test
	@DisplayName("Testa transferencia para conta Universitaria")
	void testaTransfUniversitaria() {
		Conta contaOrigem = caixa.contas.get(0);
		Conta contaDestino = caixa.contas.get(2);
		
		caixa.fazTransferencia(contaOrigem, contaDestino, 700);
		assertEquals(5500, caixa.contas.get(0).getSaldo());
		assertEquals(1400, caixa.contas.get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia de conta Especial para Universitaria")
	void testaTransfEspecial() {
		Conta contaOrigem = caixa.contas.get(1);
		Conta contaDestino = caixa.contas.get(2);
		
		caixa.fazTransferencia(contaOrigem, contaDestino, 400);
		assertEquals(1100, caixa.contas.get(1).getSaldo());
		assertEquals(1800, caixa.contas.get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia Universitaria para Especial")
	void testaTransfUniversitarioParaEspecial() {
		Conta contaOrigem = caixa.contas.get(2);
		Conta contaDestino = caixa.contas.get(1);

		caixa.fazTransferencia(contaOrigem, contaDestino, 1400);
		assertEquals(0, caixa.contas.get(2).getSaldo());
		assertEquals(2900, caixa.contas.get(1).getSaldo());
	}
	
}
