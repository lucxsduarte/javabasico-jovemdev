package refazer_exercicios.farmacia.models;

import refazer_exercicios.farmacia.utils.Vendas;

public class Perfumaria extends Produto{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	
	@Override
	public boolean foiVendido(Vendas venda) {
		if(getEstoque() >= venda.getQuantidade() && venda.getCliente().getSaldoDevedor() < 300) {
			return super.foiVendido(venda);
		}
		return false;
	}

}
