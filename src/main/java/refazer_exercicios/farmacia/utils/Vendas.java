package refazer_exercicios.farmacia.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import refazer_exercicios.farmacia.models.Cliente;
import refazer_exercicios.farmacia.models.Produto;

@Getter
@AllArgsConstructor
public class Vendas {
	private Cliente cliente;
	private Produto produto;
	private int quantidade;
	private String medico;
	
	public String toString() {
		return cliente.getNome() + " - " + produto.getNome() + " - " + (produto.getValor() * quantidade);
	}
	
	public boolean isCliente(Cliente c) {
		return c.getNome().equalsIgnoreCase(cliente.getNome());
	}
}
