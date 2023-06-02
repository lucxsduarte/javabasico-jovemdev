package refazer_exercicios.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import refazer_exercicios.farmacia.utils.Vendas;

@Getter
@AllArgsConstructor
public class Produto {
	private String nome;
	private int estoque;
	private double valor;
	
	public boolean foiVendido(Vendas venda) {
		estoque = getEstoque() - venda.getQuantidade();
		venda.getCliente().adicionaDebito(venda.getQuantidade() * getValor());
		return true;
		
	}
}
