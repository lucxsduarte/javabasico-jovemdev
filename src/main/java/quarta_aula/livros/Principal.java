package quarta_aula.livros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		List<Autor> todosAutores = new ArrayList<Autor>();
		List<Livro> todosLivros = new ArrayList<Livro>();
		
		int controle = 0;
		do {
			controle = Util.escolheOpcao();
			switch(controle) {
			case 1: 
				Util.cadastraAutor(todosAutores);
				break;
			case 2:
				Util.cadastraLivro(todosLivros, todosAutores);
				break;
			case 3:
				System.out.println(Util.listaLivrosEAutores(todosLivros));   
				break;
			case 4:
				System.out.println(Util.listarLivrosPorAutor(todosLivros));
				break;
			case 5:
				System.out.println(Util.listarLivrosPorValor(todosLivros));
				break;
			case 6:
				System.out.println(Util.listarLivrosComCrianca(todosLivros));
				break;
			case 7:
				System.out.println(Util.listarLivrosPorSexo(todosLivros));
				break;
			case 8:
				System.out.println("Você saiu do programa!");
				break;
			default:
				System.out.println("opcção inválido");
				Util.escolheOpcao();
			}
			
		}while(controle != 8);
	}

}
