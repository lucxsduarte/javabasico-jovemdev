package herança_polim.exerc_farmacia.models;

import lombok.Getter;

@Getter
public class EquipamentosMedicos extends Produto{

	public EquipamentosMedicos(String nome, int estoque, double preço) {
		super(nome, estoque, preço);
	}

}
