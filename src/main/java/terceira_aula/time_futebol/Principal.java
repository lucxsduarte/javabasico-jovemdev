package terceira_aula.time_futebol;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Time> campeonato = new ArrayList<Time>();
		int controle = 0;
		
		do {
			
			controle = Util.escolheOpcao();
			switch (controle) {
			case 1:
				Time t = new Time();
				t.cadastrarTime();
				campeonato.add(t);
				System.out.println("Time cadastrado com sucesso!");
				break;

			case 2:
				System.out.println(Util.listaJogadores(campeonato, getJogadores()));
				break;
			case 3:
				
				
				break;
			case 4:
				
				
				break;
			case 5:
				System.out.println("Você saiu do menu");
				break;
			default:
				System.out.println("Escolha uma opção válida");
				break;
			}
			
			
		}while (controle != 5);
		
		
	}

}
