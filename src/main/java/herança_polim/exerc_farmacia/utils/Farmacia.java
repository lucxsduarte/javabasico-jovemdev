package herança_polim.exerc_farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import herança_polim.exerc_farmacia.models.Cliente;
import herança_polim.exerc_farmacia.models.EquipamentosMedicos;
import herança_polim.exerc_farmacia.models.Medicamento;
import herança_polim.exerc_farmacia.models.Perfume;
import herança_polim.exerc_farmacia.models.Produto;
import lombok.Getter;

@Getter
public class Farmacia {
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void cadastraProduto(Produto produto) {
		produtos.add(produto);
	}

	public void cadastraCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente getCliente(String nome) {
		return clientes.stream().filter(cliente -> cliente.getNome().equals(nome)).findFirst().orElse(null);
	}
	
	public Produto getProduto(String nome) {
		return produtos.stream().filter(produto -> produto.getNome().equals(nome)).findFirst().orElse(null);
	}
	
	public void clearData() {
		produtos.clear();
		clientes.clear();
	}
	
	public void calculaEstoque(Produto produto, int quantidade) {
		produto.emEstoque(quantidade);
	}
	
	public void adicionaSaldo(Produto produto, Cliente cliente, int quantidade) {
		cliente.adicionaDivida(quantidade * produto.getPreço());
	}
	
	public void pagarSaldo(Cliente cliente, double preço) {
		cliente.retiraDivida(preço);
	}
	
	public void realizaVenda(Cliente cliente, Produto produto, int quantidade) {
		if( produto instanceof Medicamento && produto.emEstoque(quantidade)) {
			Medicamento medicamento = (Medicamento) produto;
			if(medicamento.reterReceita()) {
				System.out.println("Nome médico");
			}
			calculaEstoque(produto, quantidade);
			adicionaSaldo(produto, cliente, quantidade);
		} else if (produto instanceof Perfume) {
			Perfume perfume = (Perfume) produto;
			if(produto.emEstoque(quantidade) && cliente.getSaldoDevedor() < 300) {
				calculaEstoque(produto, quantidade);
				adicionaSaldo(produto, cliente, quantidade);
			}
		} else if (produto instanceof EquipamentosMedicos) {
			calculaEstoque(produto, quantidade);
			adicionaSaldo(produto, cliente, quantidade);
		}

	}
	
	
}
