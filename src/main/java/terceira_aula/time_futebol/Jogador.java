package terceira_aula.time_futebol;


import javax.swing.JOptionPane;

public class Jogador {
	String nome;
	int numero;
	int golsNoCampeonato;

	
	void cadastrarJogador() {

		nome = JOptionPane.showInputDialog("Nome Jogador");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Número do Jogador"));
		golsNoCampeonato = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos gols o jogador marcou"));

	}
	
	public String toString() {

		return "Nome: " + nome + " Numero: " + numero + "\n";

	}


	public  String getNome() {
		return nome;
	}


	public int getNumero() {
		return numero;
	}


	public int getGolsNoCampeonato() {
		return golsNoCampeonato;
	}


}
