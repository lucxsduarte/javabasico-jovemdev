package terceira_aula.time_futebol;

import java.util.List;

import javax.swing.JOptionPane;

public  class Util {

	public static int escolheOpcao() {
		String menu = "1 - Cadastrar um time\r\n"
						+ "2 - Listar todos os jogadores de um time\n"
						+ "3 - Verificar artilheiro do campeonato\n"
						+ "4 - Verificar qual time fez mais gols no campeonato\n"
						+ "5 - Sair";
		
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	public static void cadastraTime(List<Time> times) {
		Time t = new Time();
		t.cadastrarTime();
		times.add(t);
		System.out.println("Time cadastrado com sucesso!");
		
	}
	
	
	
}
