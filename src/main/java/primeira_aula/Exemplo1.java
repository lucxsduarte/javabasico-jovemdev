package primeira_aula;

import javax.swing.JOptionPane;

public class Exemplo1 {

	public static void main(String[] args) {

		int qtPessoas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de pessoas"));

		for (int i = 1; i <= qtPessoas; i++) {
			String pessoa = JOptionPane.showInputDialog("Digite seu nome");
			Double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite seu peso"));
			Double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura em metros"));
			Integer sexo = Integer
					.parseInt(JOptionPane.showInputDialog("Digite seu sexo\n 1 - Masculino ou 2 - Feminino"));

			double calc = peso / (altura * altura);

			System.out.println("Seu nome é " + pessoa);
			System.out.printf("Seu índice IMC é %.2f \n", calc);

			switch (sexo) {
			case 1:
				if (calc < 20.7) {
					System.out.println("Seu sexo é masculino e sua categoria é: Abaixo do peso");
				} else if (calc >= 20.7 && calc <= 26.4) {
					System.out.println("Seu sexo é masculino e Ssa categoria é: Peso ideal");
				} else if (calc >= 26.5 && calc <= 27.8) {
					System.out.println("Seu sexo é masculino e Ssa categoria é: Pouco acima do peso");
				} else if (calc >= 27.9 && calc <= 31.1) {
					System.out.println("Seu sexo é masculino e Ssa categoria é: Acima do peso");
				} else if (calc >= 31.2) {
					System.out.println("Seu sexo é masculino e sua categoria é: Obesidade");
				}
				break;
			case 2:
				if (calc < 19.1) {
					System.out.println("Seu sexo é feminino e sua categoria é: Abaixo do peso");
				} else if (calc >= 19.1 && calc <= 25.8) {
					System.out.println("Seu sexo é feminino e sua categoria é: Peso ideal");
				} else if (calc >= 25.9 && calc <= 27.3) {
					System.out.println("Seu sexo é feminino e sua categoria é: Pouco acima do peso");
				} else if (calc >= 27.4 && calc <= 32.3) {
					System.out.println("Seu sexo é feminino e sua categoria é: Acima do peso");
				} else if (calc >= 32.4) {
					System.out.println("Seu sexo é feminino e sua categoria é: Obesidade");
				}
				break;
			default:
				System.out.println("Escolha um Sexo válido");
				break;
			}
			System.out.println();
		}

	}

}
