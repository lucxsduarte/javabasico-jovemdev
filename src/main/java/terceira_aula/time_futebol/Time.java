package terceira_aula.time_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

	private String nome;
	private int qtJogadores;
	
	void cadastrarTime() {
		List<Jogador> listaJogadores = new ArrayList<Jogador>();
		
		nome = JOptionPane.showInputDialog("Nome Time");
		qtJogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de jogadores"));
		
		for (int i = 0; i < qtJogadores; i++) {
			Jogador j = new Jogador();
			j.cadastrarJogador();
			listaJogadores.add(j);
			
		}
		
		
	}
	
	
	
	
}
