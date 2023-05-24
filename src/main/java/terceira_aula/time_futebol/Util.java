package terceira_aula.time_futebol;

import javax.swing.JOptionPane;

public  class Util {

	static int escolheOpcao() {
		String menu = "1 - Cadastrar um time\r\n"
						+ "2 - Listar todos os jogadores de um time"
						+ "3 - Verificar artilheiro do campeonato"
						+ "4 - Verificar qual time fez mais gols no campeonato";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
		
	}
	
	
}
