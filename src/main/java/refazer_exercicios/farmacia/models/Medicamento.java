package refazer_exercicios.farmacia.models;

import refazer_exercicios.farmacia.utils.Vendas;

public class Medicamento extends Produto{

	private boolean isReceita;
	
	public Medicamento(String nome, int estoque, double valor, boolean isReceita) {
		super(nome, estoque, valor);
		this.isReceita = isReceita;
	}
	
	@Override
	public boolean foiVendido(Vendas venda) {
		if(isReceita && venda.getMedico() == null) {
			return false;
		}else {
			if(getEstoque() >= venda.getQuantidade()) {
				return super.foiVendido(venda);
			}
			return false;
		}
		
	}

	
}
