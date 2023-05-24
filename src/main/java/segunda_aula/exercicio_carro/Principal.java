package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class Principal {

	static ArrayList<Carro> carros = new ArrayList<Carro>();
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar Carro\n"
				+ "2 - Listar carros por periodo de fabricação\n"
				+ "3 - Listar carros por marca\n"
				+ "4 - Listar carros por cor\n"
				+ "5 - Sair";
		int contador = 0;
		int controle = 0;
		
		do {
			controle = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (controle == 1) {
				Carro c = new Carro();
				c.cadastro();
				carros.add(c);
				System.out.println("Carro cadastado com sucesso!");
				contador++;
			}
			if (controle == 2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial da busca"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final da busca"));
				int verificaAno = 0;
				String resultado = "";
				Collections.sort(carros);
				
				for (Carro c : carros) {
					verificaAno = c.ano;
					
					if (c.ano >= anoInicial && c.ano <= anoFinal) {
						System.out.println(c.toString());
						
					}
				}
				
				
			}
			if (controle == 3) {
				String resultadoMarca = "";
				Collections.sort(carros);
				
				
				for (Carro c : carros) {
					resultadoMarca = c.marca;
					
		            System.out.println(c.toString());
		        }
				
			}
			if (controle == 4) {
				
				String resultadoCor = "";
				
				for (Carro c : carros) {
					resultadoCor = c.cor;
					
					if (c.cor.equals(c.getCor()))	
					
					System.out.println(c.toString());
				}
				
			}
			
		}while(controle != 5);
	}
	
	public static ArrayList<Carro> listaCarrosPorPeriodo(ArrayList<Carro> carros, int anoInicial, int anoFinal){
		
		
		ArrayList<Carro> carrosPorPeriodo = new ArrayList<Carro>();
		
		for(Carro c : carros) {
			if( c.getAno() >= anoInicial && c.getAno() <= anoFinal) {
				carrosPorPeriodo.add(c);
			}
		}
		
		return carrosPorPeriodo;
	}


}
