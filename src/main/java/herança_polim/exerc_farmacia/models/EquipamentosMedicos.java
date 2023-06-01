package herança_polim.exerc_farmacia.models;

import lombok.Getter;

@Getter
public class EquipamentosMedicos extends Produto{

	public EquipamentosMedicos(String nome, int estoque, double preço) {
		super(nome, estoque, preço);
	}

	@Override
	public boolean foiVendido(Produto produto, Cliente cliente, int quantidade) {
		if(produto instanceof EquipamentosMedicos) {
			estoque -= quantidade;
			cliente.adicionaDivida(produto.getPreço() * quantidade);
			return true;
		}
		return false;
	}
}
