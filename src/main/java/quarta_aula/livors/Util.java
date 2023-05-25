package quarta_aula.livors;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Util {
	public static int escolheOpcao() {
		String menu = "1 - Cadastrar um Autor\r\n"
						+ "2 - Cadastrar um livro\n"
						+ "3 - Listar todos os livros\n"
						+ "4 - Pesquisar por autor\n"
						+ "5 - Pesquisar por faixa de preço\n"
						+ "6 - Listar livros cujo autores sejam crianças\n"
						+ "7 - Listar livros cujo autores sejam mulheres ou homens\n"
						+ "8 - Sair\n";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	public static EnumSexo escolheSexo() {
		String menu = "SEXO:\n\n";
		for( EnumSexo sexo : EnumSexo.values()) {
			menu += sexo.getCodigo() + " - " + sexo.getDescrição() + "\n";
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return EnumSexo.findById(op);
	}
	
	public static Autor cadastraAutor(List<Autor> autores){
		
		Autor a = new Autor();
		a.cadastra();
		autores.add(a);
		System.out.println("Autor Cadastrado");
		
		
		return null;
	}
	
	public static Autor escolheAutor(List<Autor> todosAutores) {
		String menu = "Escolha um autor\n";
		int pos = 1;
		for(Autor autorEscolhido : todosAutores){
			menu += pos + " - " + autorEscolhido.getNome() + "\n";
			pos++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return todosAutores.get(op-1);
		
	}
	
	public static Livro cadastraLivro(List<Livro> todosLivros, List<Autor> todosAutores) {
		Livro l = new Livro();
		
		l.setAutores(escolheAutor(todosAutores));
		
	}
	
	
	
}
	
