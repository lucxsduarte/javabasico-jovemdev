package quarta_aula.livros;

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

	public void cadastra(List<Autor> todosAutores) {
		titulo = JOptionPane.showInputDialog("Digite o título do livro");
		valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro"));

		if (valor <= 0) {
			JOptionPane.showMessageDialog(null, "Preço inválido");
			cadastra(autores);
		}
		int controle = 0;
		int contador = 0;
		Autor a = new Autor();
		do {
			a = Util.escolheAutor(todosAutores);
			if (autores.contains(a)) {
				JOptionPane.showMessageDialog(null, "Autor ja cadastrado!");
			} else {
				autores.add(a);
				contador++;
			}
			if (contador < 4) {
				String[] opcoes = { "Sim", "Não" };
				controle = JOptionPane.showOptionDialog(null, "Deseja adicionar mais um autor?", "Lista de Autores",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			} else {
				JOptionPane.showMessageDialog(null, "Máximo de autores atingido!");
				break;
			}
		} while (controle == 0 || contador == 4);

	}

	public String listarAutores() {
		String ret = "Livro: " + titulo + " Preço R$" + valor + " Reais\n";
		for (Autor autor : autores) {
			ret += autor.toString() + "\n";
		}

		return ret;
	}

	public String toString() {
		return "Título: " + titulo.toLowerCase().trim() + ", R$" + valor + " Reais";

	}

	public boolean isCrianca() {
		boolean confere = false;
		for (Autor a : autores) {
			if (a.getIdade() <= 12) {
				confere = true;
			}
		}
		return confere;
	}

	public boolean isSexo(EnumSexo sexo) {

		boolean confere = false;
		for (Autor a : autores) {
			if (a.getSexo().equals(sexo)) {
				confere = true;
			}
		}
		return confere;
	}
}
