package refazer_exercicio.banco.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import refazer_exercicios.banco.models.Conta;
import refazer_exercicios.banco.models.ContaEspecial;
import refazer_exercicios.banco.models.ContaUniversitaria;
import refazer_exercicios.banco.utils.Caixa;

public class CaixaTest {
	Caixa caixa = new Caixa();
	
	@BeforeEach
	void setup() {
		caixa.getContas().clear();
		
		Conta conta1 = new Conta(1, 10, "Joao", 500);
		Conta conta2 = new ContaEspecial(2, 10, "Guilherme", 1500, 100);
		Conta conta3 = new ContaUniversitaria(3, 10, "Lucas", 1500);
		
		caixa.cadastraConta(conta1);
		caixa.cadastraConta(conta2);
		caixa.cadastraConta(conta3);
		
	}
	
	@Test
	@DisplayName("Testa saque conta corrente")
	void testaSaqueOk() {
		Conta conta = caixa.getContas().get(0);
		
		caixa.fazSaque(500, conta);
		assertEquals(0, caixa.getContas().get(0).getSaldo());
		assertEquals(10, caixa.getContas().get(0).getAgencia());
	}
	
	@Test
	@DisplayName("Testa saque conta corrente impossivel")
	void testaSaqueImpossivel() {
		Conta conta = caixa.getContas().get(0);
		
		caixa.fazSaque(600, conta);
		assertEquals(500, caixa.getContas().get(0).getSaldo());
		assertEquals(10, caixa.getContas().get(0).getAgencia());
	}
	
	@Test
	@DisplayName("Testa saque conta especial ok")
	void testaSaqueEspecialOk() {
		Conta conta = caixa.getContas().get(1);
		
		caixa.fazSaque(1600, conta);
		assertEquals(-100, caixa.getContas().get(1).getSaldo());
		assertEquals("Guilherme", caixa.getContas().get(1).getNomeCorrentista());
	}
	
	@Test
	@DisplayName("Testa saque conta especial impossivel")
	void testaSaqueEspecialImpossivel() {
		Conta conta = caixa.getContas().get(1);
		
		caixa.fazSaque(1700, conta);
		assertEquals(1500, caixa.getContas().get(1).getSaldo());
		assertEquals(2, caixa.getContas().get(1).getNumero());
	}
	
	@Test
	@DisplayName("Testa deposito conta corrente ok")
	void testaDepositoOk() {
		Conta conta = caixa.getContas().get(0);
		
		caixa.fazDeposito(500, conta);
		assertEquals(1000, caixa.getContas().get(0).getSaldo());
	}
	
	@Test
	@DisplayName("Testa deposito conta corrente impossivel")
	void testaDepositoImpossivel() {
		Conta conta = caixa.getContas().get(0);
		
		caixa.fazDeposito(-500, conta);
		assertEquals(500, caixa.getContas().get(0).getSaldo());
	}
	
	@Test
	@DisplayName("Testa deposito conta uni impossivel")
	void testaDepositoUniImpossivel() {
		Conta conta = caixa.getContas().get(2);
		
		caixa.fazDeposito(600, conta);
		assertEquals(1500, caixa.getContas().get(2).getSaldo());
	}
	
	
	@Test
	@DisplayName("Testa transferencia entre conta corrente")
	void testaTransfCorrente() {
		Conta contaOrigem = caixa.getContas().get(0);
		Conta contaDestino = caixa.getContas().get(1);
		
		caixa.fazTransferencia(500, contaOrigem, contaDestino);
		assertEquals(0, caixa.getContas().get(0).getSaldo());
		assertEquals(2000, caixa.getContas().get(1).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia entre conta corrente e conta Uni ok")
	void testaTransfCorrenteUniOk() {
		Conta contaOrigem = caixa.getContas().get(0);
		Conta contaDestino = caixa.getContas().get(2);
		
		caixa.fazTransferencia(500, contaOrigem, contaDestino);
		assertEquals(0, caixa.getContas().get(0).getSaldo());
		assertEquals(2000, caixa.getContas().get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia entre conta corrente e conta Uni impossivel")
	void testaTransfCorrenteUniImpossivel() {
		Conta contaOrigem = caixa.getContas().get(0);
		Conta contaDestino = caixa.getContas().get(2);
		
		caixa.fazTransferencia(600, contaOrigem, contaDestino);
		assertEquals(500, caixa.getContas().get(0).getSaldo());
		assertEquals(1500, caixa.getContas().get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia entre conta Especial e conta corrente ok")
	void testaTransfEspecialOk() {
		Conta contaOrigem = caixa.getContas().get(1);
		Conta contaDestino = caixa.getContas().get(0);
		
		caixa.fazTransferencia(1600, contaOrigem, contaDestino);
		assertEquals(-100, caixa.getContas().get(1).getSaldo());
		assertEquals(2100, caixa.getContas().get(0).getSaldo());
	}
	
	@Test
	@DisplayName("Testa transferencia entre conta especial e conta Uni impossivel")
	void testaTransfCorrenteUniImpossivel2() {
		Conta contaOrigem = caixa.getContas().get(1);
		Conta contaDestino = caixa.getContas().get(2);
		
		caixa.fazTransferencia(600, contaOrigem, contaDestino);
		assertEquals(1500, caixa.getContas().get(1).getSaldo());
		assertEquals(1500, caixa.getContas().get(2).getSaldo());
	}
	
}
