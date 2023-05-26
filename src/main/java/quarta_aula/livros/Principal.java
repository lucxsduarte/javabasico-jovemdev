package quarta_aula.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * 
 * @author LUCAS DUARTE
 *
 */

public class Principal {

	public static void main(String[] args) {
		List<Autor> todosAutores = new ArrayList<Autor>();
		List<Livro> todosLivros = new ArrayList<Livro>();

		int controle = 0;
		do {
			controle = Util.escolheOpcao();
			switch (controle) {
			case 1:
				Util.cadastraAutor(todosAutores);
				break;
			case 2:
				Util.cadastraLivro(todosLivros, todosAutores);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.listaLivrosEAutores(todosLivros));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, Util.listarLivrosPorAutor(todosLivros, todosAutores));
				break;
			case 5:
				JOptionPane.showMessageDialog(null, Util.listarLivrosPorValor(todosLivros));
				break;
			case 6:
				JOptionPane.showMessageDialog(null, Util.listarLivrosComCrianca(todosLivros, todosAutores));
				break;
			case 7:
				JOptionPane.showMessageDialog(null, Util.listarLivrosPorSexo(todosLivros));
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Você saiu do programa!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}

		} while (controle != 8);
	}

}
