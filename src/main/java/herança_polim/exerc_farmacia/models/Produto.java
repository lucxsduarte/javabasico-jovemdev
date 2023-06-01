package herança_polim.exerc_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
	protected String nome;
	protected int estoque;
	protected double preço;
	
	public boolean emEstoque(int quantidade) {
		return estoque >= quantidade;
	}
	
	public void removeEstoque(int quantidade) {
		estoque -= quantidade;
	}
	
}
