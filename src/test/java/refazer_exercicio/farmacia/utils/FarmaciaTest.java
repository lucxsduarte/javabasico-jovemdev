package refazer_exercicio.farmacia.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import refazer_exercicios.farmacia.models.Cliente;
import refazer_exercicios.farmacia.models.EquipMedicos;
import refazer_exercicios.farmacia.models.Medicamento;
import refazer_exercicios.farmacia.models.Perfumaria;
import refazer_exercicios.farmacia.utils.Farmacia;

public class FarmaciaTest {
	
	private Farmacia farmacia = new Farmacia();
	Cliente cliente = null;
	private Medicamento m1 = null;
	private Medicamento m2 = null;
	private Perfumaria p1 = null;
	private EquipMedicos e1 = null;
	
	@BeforeEach
	public void setup() {
		farmacia.getVendas().clear();
		cliente = new Cliente("Cliente 1", 0);
		m1 = new Medicamento("M1", 10, 10, false);
		m2 = new Medicamento("M2", 10, 10, true);
		p1 = new Perfumaria("P1", 10, 10);
		e1 = new EquipMedicos("E1", 0, 10);
		
	}
	
	
	@Test
	@DisplayName("cliente pagar conta")
	void testeClientePaga() {
		cliente.adicionaDebito(100);
		cliente.pagarConta(100);
		assertEquals(0, cliente.getSaldoDevedor());
	}
	
	
	@Test
	@DisplayName("venda de medicamento com receita sem informar o médico")
	void testeVenderMedicamentoComReceitaSemMedico() {
		farmacia.vender(cliente, m2, 3, null);
		assertEquals(0, cliente.getSaldoDevedor());
		assertEquals(10, m2.getEstoque());
	}
	
	@Test
	@DisplayName("venda de medicamento com receita e informar o médico")
	void testeVenderMedicamentoComReceitaComMedico() {
		farmacia.vender(cliente, m2, 3, "Jorge");
		assertEquals(30, cliente.getSaldoDevedor());
		assertEquals(7, m2.getEstoque());
	}
	
	@Test
	@DisplayName("venda de medicamento sem receita acima do estoque")
	void testeVenderMedicamentoAcimaEstoque() {
		farmacia.vender(cliente, m1, 11, null);
		assertEquals(0, cliente.getSaldoDevedor());
		assertEquals(10, m1.getEstoque());
	}
	
	@Test
	@DisplayName("venda perfumaria ok")
	void testeVendaPerfumariaOk() {
		farmacia.vender(cliente, p1, 1, null);
		assertEquals(10, cliente.getSaldoDevedor());
		assertEquals(9, p1.getEstoque());
	}
	
	@Test
	@DisplayName("venda perfumaria impossivel")
	void testeVendaPerfumariaImpossivel() {
		cliente.adicionaDebito(500);
		farmacia.vender(cliente, p1, 1, null);
		assertEquals(500, cliente.getSaldoDevedor());
		assertEquals(10, p1.getEstoque());
	}
	
	@Test
	@DisplayName("venda equipMedico sem estoque")
	void testeVendaEquipMedicoSemEstoque() {
		farmacia.vender(cliente, e1, 1, null);
		assertEquals(10, cliente.getSaldoDevedor());
		assertEquals(-1, e1.getEstoque());
	}
	
}
