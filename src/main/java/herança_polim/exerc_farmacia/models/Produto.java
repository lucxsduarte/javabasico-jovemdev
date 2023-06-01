package herança_polim.exerc_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
	protected String nome;
	protected int estoque;
	protected double preço;
	
	public boolean foiVendido(Produto produto, Cliente cliente, int quantidade) {
		if(estoque >= quantidade) {
			estoque -= quantidade;
			cliente.adicionaDivida(produto.getPreço() * quantidade);
			return true;
		}
		return false;
	}
}
