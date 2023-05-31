package herança_polim.exerc_banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	@DisplayName("Testa conta existe")
	void testaContaExiste() {
		caixa.existeConta(caixa.contas.get(0));
		assertEquals(1, caixa.contas.get(0).getNumero());
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
		assertEquals("Erro! Saldo máximo 2000", caixa.contas.get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Testa saque conta corrente")
	void testaSaque() {
		caixa.fazSaque(caixa.contas.get(0), 500);
		assertEquals(5000, caixa.contas.get(0).getSaldo());
	}
}
