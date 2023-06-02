package refazer_exercicios.disciplina2;

import java.util.ArrayList;
import java.util.List;

import refazer_exercicios.disciplina.enums.EnumFormacao;
import refazer_exercicios.disciplina.models.Disciplina;

public class Professor {
	private String nome;
	private EnumFormacao formacao;
	private List<Disciplina> disciplinasLecionadas;

	public Professor(String nome, EnumFormacao formacao) {
		this.nome = nome;
		this.formacao = formacao;
		this.disciplinasLecionadas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public EnumFormacao getFormacao() {
		return formacao;
	}

	public List<Disciplina> getDisciplinasLecionadas() {
		return disciplinasLecionadas;
	}

	public void cadastrarDisciplina(Disciplina disciplina) {
		disciplinasLecionadas.add(disciplina);
	}
	
	
}