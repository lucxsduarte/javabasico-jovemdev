package herança_polim.exerc_farmacia.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import herança_polim.exerc_farmacia.models.Cliente;
import herança_polim.exerc_farmacia.models.EquipamentosMedicos;
import herança_polim.exerc_farmacia.models.Medicamento;
import herança_polim.exerc_farmacia.models.Perfume;
import herança_polim.exerc_farmacia.models.Produto;

public class FarmaciaTest {
	
	Farmacia farmacia = new Farmacia();
	
	@BeforeEach
	void setup() {
		farmacia.clearData();
		Cliente cliente1 = new Cliente("Cliente 1", 100);
		Cliente cliente2 = new Cliente("Cliente 2", 450);
		Cliente cliente3 = new Cliente("Cliente 3", 600);
		
		farmacia.cadastraCliente(cliente1);
		farmacia.cadastraCliente(cliente2);
		farmacia.cadastraCliente(cliente3);
		
		Produto produto1 = new Medicamento("Medicamento 1", 100, 30.0, true);
		Produto produto2 = new Medicamento("Medicamento 2", 12, 89, false);
		Produto produto3 = new Perfume("Perfume 1", 20, 29);
		Produto produto4 = new EquipamentosMedicos("Equipamento 1", 0, 27);
		
		farmacia.cadastraProduto(produto1);
		farmacia.cadastraProduto(produto2);
		farmacia.cadastraProduto(produto3);
		farmacia.cadastraProduto(produto4);
	}
	
	@Test
	@DisplayName("Teste cadastra cliente")
	void cadastraCliente() {
		Cliente cliente4 = new Cliente("Cliente 4", 50);
		farmacia.cadastraCliente(cliente4);
		assertEquals(4, farmacia.getClientes().size());
	}
	
	@Test
	@DisplayName("Teste cadastra produto")
	void cadastraProduto() {
		Produto produto5 = new Perfume("Perfume 2", 0, 60);
		farmacia.cadastraProduto(produto5);
		assertEquals(5, farmacia.getProdutos().size());
	}
	
	@Test
	@DisplayName("Teste realiza venda perfume")
	void realizaVendasPerfume() {
		Cliente cliente = farmacia.getClientes().get(0);
		Produto produto = farmacia.getProdutos().get(2);
		
		farmacia.realizaVenda(cliente, produto, 1);
		assertEquals(129, farmacia.getClientes().get(0).getSaldoDevedor());
		assertEquals(19, farmacia.getProdutos().get(2).getEstoque());
	}
	
	@Test
	@DisplayName("Teste falha na venda por debito perfume ")
	void realizaVendaFalhaDebito() {
		Cliente cliente = farmacia.getClientes().get(1);
		Produto produto = farmacia.getProdutos().get(2);
		
		farmacia.realizaVenda(cliente, produto, 1);
		assertEquals(450, farmacia.getClientes().get(1).getSaldoDevedor());
		assertEquals(20, farmacia.getProdutos().get(2).getEstoque());
	}
	
	@Test
	@DisplayName("Teste realiza venda Medicamento sem reter")
	void realizaVendasMedicamentoSemReter() {
		Cliente cliente = farmacia.getClientes().get(0);
		Produto produto = farmacia.getProdutos().get(1);
		
		farmacia.realizaVenda(cliente, produto, 1);
		assertEquals(189, farmacia.getClientes().get(0).getSaldoDevedor());
		assertEquals(11, farmacia.getProdutos().get(1).getEstoque());
		assertEquals("Medicamento 2", farmacia.getProdutos().get(1).getNome());
	}
	
	@Test
	@DisplayName("Teste realiza venda Medicamento com reter")
	void realizaVendasMedicamentoComReter() {
		
		if(farmacia.getProdutos().get(0) instanceof Medicamento) {
			Medicamento medicamento = (Medicamento) farmacia.getProdutos().get(0);
			Cliente cliente = farmacia.getClientes().get(0);
			
			farmacia.realizaVenda(cliente, medicamento, 1);
			assertEquals(130, farmacia.getClientes().get(0).getSaldoDevedor());
			assertEquals(99, farmacia.getProdutos().get(0).getEstoque());
			assertEquals("Medicamento 1", farmacia.getProdutos().get(0).getNome());
		}
	}
}
