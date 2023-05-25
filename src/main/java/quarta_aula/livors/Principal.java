package quarta_aula.livors;

import java.util.ArrayList;
import java.util.List;

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
			}
			
			
		}while(controle != 8);
	}

}
