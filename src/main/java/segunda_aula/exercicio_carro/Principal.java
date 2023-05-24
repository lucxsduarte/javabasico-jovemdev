package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Principal {

	static List<Carro> carros = new ArrayList<Carro>();

	public static void main(String[] args) {

		String menu = "1 - Cadastrar Carro\n" + "2 - Listar carros por periodo de fabricação\n"
				+ "3 - Listar carros por marca\n" + "4 - Listar carros por cor\n" + "5 - Sair";
		int controle = 0;

		do {
			controle = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (controle == 1) {
				Carro c = new Carro();
				c.cadastro();
				carros.add(c);
				System.out.println("Carro cadastado com sucesso!");
			}
			if (controle == 2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial da busca"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final da busca"));
				int contador = 0;
				String ret = "";
				for (Carro c : carros) {
					if (c.getAno() >= anoInicial && c.getAno() <= anoFinal) {
						contador++;
						ret += c.toString() + "\n";
					}

				}
				System.out.println(ret + "\nequivale a " + calculaPorcentagem(carros, contador) + "% dos carros \n"
						+ "______________\n");
			}
			if (controle == 3) {
				String resultadoMarca = JOptionPane.showInputDialog("Digite a marca");
				int contador = 0;
				String ret = "";
				for (Carro c : carros) {
					if (resultadoMarca.equalsIgnoreCase(c.getMarca())) {
						contador++;
						ret += c.toString() + "\n";
					}

				}
				System.out.println(ret + "\nequivale a " + calculaPorcentagem(carros, contador) + "% dos carros \n"
						+ "______________\n");
			}
			if (controle == 4) {
				String resultadoCor = JOptionPane.showInputDialog("Digite a cor");
				int contador = 0;
				String ret = "";
				for (Carro c : carros) {

					if (resultadoCor.equalsIgnoreCase(c.getCor())) {
						contador++;
						ret += c.toString() + "\n";
					}

				}
				System.out.println(ret + "\nequivale a " + calculaPorcentagem(carros, contador) + "% dos carros \n"
						+ "______________\n");
			}

		} while (controle != 5);
	}

	public static double calculaPorcentagem(List<Carro> carros, int contador) {

		return (double) contador / (double) (carros.size()) * 100;
	}

}
