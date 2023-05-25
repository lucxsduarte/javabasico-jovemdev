package quarta_aula.livors;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

	private String nome;
	private int idade;
	private EnumSexo sexo;
	
	public void cadastra() {
		nome = JOptionPane.showInputDialog("Digite o nome do Autor");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do Autor"));
		sexo = Util.escolheSexo();
		if(!validar()) {
			cadastra();
		}
	}
	
	public boolean validar() {
		if( idade < 0) {
			JOptionPane.showMessageDialog(null, "Idade inválida");
			return false;
		}
		return true;
	}
}


