package quarta_aula.livros;

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
		nome = JOptionPane.showInputDialog("Digite o nome e sobrenome do autor").trim();
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do Autor"));
		sexo = Util.escolheSexo();
		if (!validar()) {
			cadastra();
		}
	}

	public boolean validar() {
		String[] palavras = nome.split(" ");

		if (palavras.length != 2) {
			JOptionPane.showMessageDialog(null, "Nome " + nome + " inválido");
			return false;
		} else if (idade <= 0) {
			JOptionPane.showMessageDialog(null, "Idade inválida, deve ser um valor maior que 0");
			return false;
		} else if (sexo != EnumSexo.MASCULINO && sexo != EnumSexo.FEMININO) {
			JOptionPane.showMessageDialog(null, "Sexo inválido");
			return false;
		}

		return true;
	}

	public String toString() {
		return "Autor: " + nome.toUpperCase() + " / sexo: " + sexo + " / idade: " + idade + " anos";
	}

}
