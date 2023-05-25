package terceira_aula.time_futebol;


import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Jogador {
	private String nome;
	private int numero;
	private int golsNoCampeonato;
	
	public void cadastrarJogador() {

		nome = JOptionPane.showInputDialog("Nome Jogador");
		numero = Integer.parseInt(JOptionPane.showInputDialog("Número do Jogador"));
		golsNoCampeonato = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos gols o jogador marcou"));

	}
	
	@Override
	public String toString() {
		String nomeJogador = nome;
		int numeroGols = numero;
		int gols = golsNoCampeonato;
		
		return "Nome: " + nomeJogador + " Numero: " + numeroGols + " Gols: " + gols + "\n";

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
