package terceira_aula.time_futebol;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Time {

	private String nomeTime;
	private int qtJogadores;
	public ArrayList<Jogador> jogadores;

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
		qtJogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de jogadores"));
		
		Jogador j = new Jogador();
		
		for (int i = 0; i < qtJogadores; i++) {
			j.cadastrarJogador();
			jogadores.add(j);
			

		}
			

	}

	

}
