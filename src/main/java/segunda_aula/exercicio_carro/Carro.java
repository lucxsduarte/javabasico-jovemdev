package segunda_aula.exercicio_carro;


import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carro {

	private String marca;
	private int ano;
	private String cor;
	
	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public String getCor() {
		return cor;
	}

	
	enum corEnum {
		VERMELHO("Vermelho"),
		PRETO("Preto"),
		BRANCO("Branco"),
		PRATA("Prata");

		final String corVeiculo;
		
		private corEnum(String corVeiculo){
			this.corVeiculo = corVeiculo;
		}
		
		public String getCorVeiculo() {
			return this.corVeiculo;
		}

		
	}
	
	void cadastro() {
		marca = JOptionPane.showInputDialog("Digite a marca");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do veículo"));
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Escolha a cor do veículo\n1 - VERMELHO\n2 - PRETO\n3 - BRANCO\n4 - PRATA"));
			
			if (op == 1) {
				cor = corEnum.VERMELHO.getCorVeiculo();
				break;
			} 
			else if (op == 2) {
				cor = corEnum.PRETO.getCorVeiculo();
				break;
			}
			else if (op == 3) {
				cor = corEnum.BRANCO.getCorVeiculo();
				break;
			}else if (op == 4) {
				cor = corEnum.PRATA.getCorVeiculo();
				break;
			}
			else {
				JOptionPane.showMessageDialog(null, "Escolha uma cor válida");
			}
		}while(op != 1 || op != 2 || op != 3 || op != 4);
	}
	
	public String toString() {
		int anoCarro = ano;
		String marcaCarro = marca;
		
		return marcaCarro.toUpperCase() + " " + anoCarro + " " + cor;
	}
	

}
