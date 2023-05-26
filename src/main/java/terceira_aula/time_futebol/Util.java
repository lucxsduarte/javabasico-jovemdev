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
	public static void cadastraTime(List<Time> campeonato) {
		Time t = new Time();
		t.cadastrarTime();
		campeonato.add(t);
		System.out.println("Time cadastrado com sucesso!");
		
	}
	
	public static Time escolheTime(List<Time> campeonato) {
		String menu = "Escolhe um time\n";
		int pos = 1;
		for (Time t : campeonato) {
			menu += pos + " - " + t.getNomeTime() + "\n";
			pos++;
		}
		int operacao = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return campeonato.get(operacao-1);
		
	}
	
	public static String artilheiroCampeonato(List<Time> campeonato) {
		Jogador artilheiro = new Jogador();
		for (Time t : campeonato) {
			if(t.verificaArtilheiro().getGolsNoCampeonato() > artilheiro.getGolsNoCampeonato()) {
				artilheiro = t.verificaArtilheiro();
			}
		}
		return artilheiro.toString();
	}
	
	public static String listaJogadores(List<Time> campeonato) {
		Time t = escolheTime(campeonato);
		return t.listarJogadores();
		
	}
	
	public static String timeMaisGols(List<Time> campeonato) {
		Time timeGols = new Time();
		for (Time t : campeonato) {
			if(t.getGols() > timeGols.getGols()) {
				timeGols = t;
			}
		}
		return timeGols.getNomeTime();
	}
	
}
