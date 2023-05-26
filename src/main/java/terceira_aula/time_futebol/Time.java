package terceira_aula.time_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Time {

	private String nomeTime;
	private int qtJogadores;
	private ArrayList<Jogador> jogadores;

	public String getNomeTime() {
		return nomeTime;
	}

	public int getQtJogadores() {
		return qtJogadores;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	void cadastrarTime() {
		jogadores = new ArrayList<Jogador>();
		nomeTime = JOptionPane.showInputDialog("Nome Time");
		do {
			qtJogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de jogadores"));
		}while(qtJogadores < 1);
		
		for (int i = 0; i < qtJogadores; i++) {
			Jogador j = new Jogador();
			j.cadastrarJogador();
			jogadores.add(j);

		}

	}

	public String listarJogadores() {
		
		String escolherTime = JOptionPane.showInputDialog("Digite o nome do time");
		String ret = "";
		
		if( getNomeTime().equalsIgnoreCase(escolherTime)) {
			for (Jogador j : jogadores) {
				
				ret += j.toString();
			}
		}
		return ret;
	}

	public Jogador verificaArtilheiro() {
		Jogador artilheiro = jogadores.get(0);
		
		for (Jogador jogador : jogadores) {
			if (jogador.getGolsNoCampeonato() > artilheiro.getGolsNoCampeonato()) {
				artilheiro = jogador;
			}
		}
		return artilheiro;
	}
	
	
	

}
