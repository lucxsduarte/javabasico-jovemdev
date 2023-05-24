package terceira_aula.time_futebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {

	private String nome;
	private int numero;
	private int golsNoCampeonato;
	private String time;
	
	
	void cadastrarJogador() {
		
		nome = JOptionPane.showInputDialog("Nome Jogador");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Número do Jogador")); 
		golsNoCampeonato = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos gols o jogador marcou"));
		
	}
	
}
