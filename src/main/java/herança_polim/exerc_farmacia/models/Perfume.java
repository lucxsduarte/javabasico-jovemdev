package herança_polim.exerc_farmacia.models;

import lombok.Getter;

@Getter
public class Perfume extends Produto{

	public Perfume(String nome, int estoque, double preço) {
		super(nome, estoque, preço);
	}


	public boolean devedor(double saldoDevedor) {
		return saldoDevedor < 300;
	}
	
	public boolean venda(int quantidade, double preço	) {
		return emEstoque(quantidade) && devedor(preço);
	}
	
	
}
