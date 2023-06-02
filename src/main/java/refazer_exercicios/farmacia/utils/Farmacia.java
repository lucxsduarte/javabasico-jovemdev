package refazer_exercicios.farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import refazer_exercicios.farmacia.models.Cliente;
import refazer_exercicios.farmacia.models.Produto;

@Getter
public class Farmacia {

	List<Vendas> vendas = new ArrayList<Vendas>();
	
	
	public void vender(Cliente cliente, Produto produto, int quantidade, String medico) {
		Vendas venda = new Vendas(cliente, produto, quantidade, medico);
		if(produto.foiVendido(venda)) {
			vendas.add(venda);
		}
	}
}
