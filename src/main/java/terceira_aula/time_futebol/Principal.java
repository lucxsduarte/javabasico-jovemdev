package terceira_aula.time_futebol;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class Principal {

	public static void main(String[] args) {
		List<Time> campeonato = new ArrayList<Time>();
		int controle = 0;
		
		do {
			
			controle = Util.escolheOpcao();
			switch (controle) {
			case 1:
				Util.cadastraTime(campeonato);
				break;

			case 2:
				String resultado = "";
				for( Time time : campeonato) {
					resultado += time.listarJogadores();
					
				}
				System.out.println(resultado);
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
