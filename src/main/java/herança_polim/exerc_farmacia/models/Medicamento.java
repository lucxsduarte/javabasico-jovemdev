package herança_polim.exerc_farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto{
	boolean reterReceita;
	
	public Medicamento(String nome, int estoque, double preço, boolean reterReceita) {
		super(nome, estoque, preço);
		this.reterReceita = reterReceita;
	}
	
	public boolean reterReceita() {
		return reterReceita;
	}
}
