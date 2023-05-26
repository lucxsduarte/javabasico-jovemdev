package quarta_aula.livros;

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
		String menu = "Escolha o sexo:\n";
		for( EnumSexo sexo : EnumSexo.values()) {
			menu += sexo.getCodigo() + " - " + sexo.getDescrição() + "\n";
		}
		
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return EnumSexo.findById(op);
	}
	
	public static void cadastraAutor(List<Autor> todosAutores){
		
		Autor a = new Autor();
		a.cadastra();
		todosAutores.add(a);
		JOptionPane.showMessageDialog(null, "Autor cadastrado!");
		
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
	
	public static void cadastraLivro(List<Livro> todosLivros, List<Autor> autores) {
		Livro livro = new Livro();
		livro.cadastra(autores);
		todosLivros.add(livro);
		JOptionPane.showMessageDialog(null, "Livro cadastrado!");
		
	}
	
	public static String listaLivrosEAutores(List<Livro> todosLivros) {
		String ret = "Segue abaixo a lista de livros \n ------------------------------\n";
		for (Livro livro : todosLivros) {
			ret += livro.listarAutores() + "\n";
		}
		
		return ret;
	}
	
	public static String listarLivrosPorValor(List<Livro> todosLivros) {
		double valorMin = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo"));
		double valorMax = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo"));
		String ret = "Livros de R$" + valorMin + " até R$" + valorMax + " :\n";
		
		for (Livro livro : todosLivros) {
			if (livro.getValor() >= valorMin && livro.getValor() <= valorMax) {
				ret += "Título " + livro.getTitulo() + " Preço R$" + livro.getValor() + "\n";
			}
		}
		
		return ret;
	}
	
	public static String listarLivrosComCrianca(List<Livro> todosLivros){
		String ret = "Livros cujo autor é criança: \n";
		
		for (Livro livro : todosLivros) {
			for (Autor autor : livro.getAutores()) {
				if(autor.getIdade() <= 12) {
					ret += livro.getTitulo() + " ";
				}
			}
		}
		
		return ret;
			
	}
	
	public static String listarLivrosPorSexo(List<Livro> todosLivros) {
		
		String ret = "Livros com autores do sexo escolhido: " ;
		EnumSexo sexoEscolhido = escolheSexo();
		
		for (Livro livro : todosLivros) {
			
			for (Autor autor : livro.getAutores()) {
				if(autor.getSexo() != sexoEscolhido) {
					break;
					
				}else {
					ret += livro.getTitulo();
				}
			}
		}
		
		return ret;
	}
	
	public static String listarLivrosPorAutor(List<Livro> todosLivros){
		String escolhaAutor = JOptionPane.showInputDialog("Digite o nome e sobrenome do autor");
		String ret = "Autor: \n" + escolhaAutor + "\n\nLivros do autor: \n";
		
		for (Livro livroEscolhido : todosLivros) {
			for (Autor autorEscolhido : livroEscolhido.getAutores()) {
				if ( autorEscolhido.getNome().equalsIgnoreCase(escolhaAutor)) {
					ret += livroEscolhido.getTitulo() + " ";
					break;
				}
			}
		}
		
		return ret;
	}
	
}
	
