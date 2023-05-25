package terceira_aula.time_futebol;

import java.util.List;
import javax.swing.JOptionPane;

public  class Util {

	static int escolheOpcao() {
		String menu = "1 - Cadastrar um time\r\n"
						+ "2 - Listar todos os jogadores de um time\n"
						+ "3 - Verificar artilheiro do campeonato\n"
						+ "4 - Verificar qual time fez mais gols no campeonato\n"
						+ "5 - Sair";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	static String listaJogadores(List<Time> campeonato, List<Jogador> jogadores) {
		
		String escolherTime = JOptionPane.showInputDialog("Digite o nome do time");
		String ret = "";
		
		for (Time t : campeonato) {
			
			if( t.getNomeTime().equalsIgnoreCase(escolherTime)) {
				
				for (Jogador j : jogadores) {
					
					ret += j.toString();
					
				}
				
				
			}
		}
			
		
		
		return ret;
		
	}
	
	
	
}
