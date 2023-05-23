package segunda_aula.exercicio_carro;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	static ArrayList<Carro> carros = new ArrayList<Carro>();
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar Carro\n"
				+ "2 - Listar carros por periodo de fabricação\n"
				+ "3 - Listar carros por marca\n"
				+ "4 - Listar carros por cor\n"
				+ "5 - Sair";
		
		int controle = 0;
		do {
			controle = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if (controle == 1) {
				Carro c = new Carro();
				c.cadastro();
				carros.add(c);
			}
			if (controle == 2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial da busca"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final da busca"));
				int verificaAno = 0;
				String resultado = "";
				
				for (Carro c : carros) {
					verificaAno = c.ano;
					
					if (c.ano >= anoInicial && c.ano <= anoFinal) {
						System.out.println(c.toString());
					}
					
				}
				System.out.println(resultado + "\n");
				
			}
		}while(controle != 5);
	}
	

}
