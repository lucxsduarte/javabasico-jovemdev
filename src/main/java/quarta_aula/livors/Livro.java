package quarta_aula.livors;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {
	private String titulo;
	private double valor;
	private List<Autor> autores = new ArrayList<Autor>();
	
	public void cadastraLivro() {
		titulo = JOptionPane.showInputDialog("Digite o título do livro");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro"));
		String resp = "";
		do {
			
			autores.add(Util.cadastraAutor(autores));
			
			JOptionPane.showMessageDialog(null, "Deseja adicionar mais um autor?");
		}while(resp != "S");
		
		
		
		
	}
	
	public String toString() {
		String nomeLivro = titulo;
		Double valorLivro = valor;
		List<Autor> autor = autores;
		
		return "Titulo: " + nomeLivro.toLowerCase() + " Preço: R$" + valorLivro + " Autores: " + autor + "\n";
	}

	public Livro(String titulo, double valor, List<Autor> autores) {
		this.titulo = titulo;
		this.valor = valor;
		this.autores = autores;
	}
 	
	
	
}
