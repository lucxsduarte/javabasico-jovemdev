package terceira_aula.time_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, Util.listaJogadores(campeonato));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.artilheiroCampeonato(campeonato));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, Util.timeMaisGols(campeonato));
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Você saiu do menu");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
				break;
			}
			
		}while (controle != 5);
		
		
	}

}
