package primeira;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

		int controle = 1;

		do {
			String nome = JOptionPane.showInputDialog("Digite seu nome");
			Double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite seu peso"));
			Double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura"));
			int sexo = Integer
					.parseInt(JOptionPane.showInputDialog("Escolha seu sexo:\n 1 - MASCULINO\n 2 - FEMININO"));

			Pessoa pessoa = new Pessoa(nome, peso, altura, sexo);
			lista.add(pessoa);
			controle = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar cadastrando? \n 1 - SIM \n 2 - NÃO"));

		} while (controle == 1);

		for (Pessoa i : lista) {
			System.out.printf("Seu nome é: " + i.getNome());
			System.out.printf("\nSeu IMC é: %.2f", calculaIMC(i.getPeso(), i.getAltura()));

			if (i.getSexo() == 1) {

				if (calculaIMC(i.getPeso(), i.getAltura()) < 20.7) {
					System.out.println("\nSeu sexo é masculino e sua categoria é: Abaixo do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 20.7
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 26.4) {
					System.out.println("\nSeu sexo é masculino e sua categoria é: Peso ideal");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 26.5
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 27.8) {
					System.out.println("\nSeu sexo é masculino e sua categoria é: Pouco acima do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 27.9
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 31.1) {
					System.out.println("\nSeu sexo é masculino e sua categoria é: Acima do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 31.2) {
					System.out.println("\nSeu sexo é masculino e sua categoria é: Obesidade");
				}
			}

			if (i.getSexo() == 2) {
				if (calculaIMC(i.getPeso(), i.getAltura()) < 19.1) {
					System.out.println("\nSeu sexo é feminino e sua categoria é: Abaixo do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 19.1
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 25.8) {
					System.out.println("\nSeu sexo é feminino e sua categoria é: Peso ideal");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 25.9
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 27.3) {
					System.out.println("\nSeu sexo é feminino e sua categoria é: Pouco acima do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 27.4
						&& calculaIMC(i.getPeso(), i.getAltura()) <= 32.3) {
					System.out.println("\nSeu sexo é feminino e sua categoria é: Acima do peso");
				} else if (calculaIMC(i.getPeso(), i.getAltura()) >= 32.4) {
					System.out.println("\nSeu sexo é feminino e sua categoria é: Obesidade");
				}
			}

		}

	}

	public static double calculaIMC(double peso, double altura) {
		double calculo = peso / (altura * altura);
		return calculo;
	}

}
