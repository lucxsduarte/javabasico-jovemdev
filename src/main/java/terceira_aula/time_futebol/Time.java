package terceira_aula.time_futebol;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Time {

	private String nomeTime;
	private ArrayList<Jogador> jogadores;


	void cadastrarTime() {
		jogadores = new ArrayList<Jogador>();
		nomeTime = JOptionPane.showInputDialog("Nome Time");
		String controle = "";
		
		do {
			
			Jogador j = new Jogador();
			j.cadastrarJogador();
			jogadores.add(j);
			controle = JOptionPane.showInputDialog("Cadastrar outro jogador? ( S / N )");
		}while(controle.equalsIgnoreCase("S"));

	}

	public String listarJogadores() {
		
		String ret = "Jogadores do time: " + nomeTime.toUpperCase() + "\n";
		
		for (Jogador j : jogadores) {
			ret += j;
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
	
	public int getGols() {
		int golsDoTime = 0;
		for (Jogador j : jogadores) {
			golsDoTime += j.getGolsNoCampeonato();
		}
		return golsDoTime;
	}
	

}
