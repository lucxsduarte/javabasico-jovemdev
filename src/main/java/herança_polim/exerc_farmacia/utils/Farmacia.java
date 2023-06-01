package herança_polim.exerc_farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import herança_polim.exerc_farmacia.models.Cliente;
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
	

	public boolean fazVenda(Produto produto, Cliente cliente, int quantidade) {
		if(produto.foiVendido(produto, cliente, quantidade)){
			return true;
		}
		return false;
	}	
}
