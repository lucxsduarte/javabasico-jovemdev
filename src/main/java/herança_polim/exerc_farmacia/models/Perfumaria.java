package herança_polim.exerc_farmacia.models;

import lombok.Getter;

@Getter
public class Perfumaria extends Produto {

	public Perfumaria(String nome, int estoque, double preço) {
		super(nome, estoque, preço);
	}

	@Override
	public boolean foiVendido(Produto produto, Cliente cliente, int quantidade) {
		if (estoque >= quantidade) {
			if (cliente.getSaldoDevedor() < 300) {
				estoque -= quantidade;
				cliente.adicionaDivida(produto.getPreço() * quantidade);
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

}
