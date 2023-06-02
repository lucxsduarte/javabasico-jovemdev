package refazer_exercicios.disciplina.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import refazer_exercicios.disciplina.models.Aluno;
import refazer_exercicios.disciplina.models.Disciplina;
import refazer_exercicios.disciplina.models.Professor;
import testes_unitarios_primeira_aula.exerc_disciplina.enums.EnumFormacao;

@Getter
public class Escola {
	
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	private List<Professor> listaProfessores = new ArrayList<Professor>();
	
	public void cadastraAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}
	
	public void cadastraDisciplina(Disciplina disciplina) {
		listaDisciplina.add(disciplina);
	}
	
	public void cadastraProfessor(Professor professor) {
		listaProfessores.add(professor);
	}
	
	public void matricularAluno(Aluno aluno, Disciplina disciplina) {
		aluno.adicionarDisciplina(disciplina);
	}
	
	public void informarNotas(Aluno aluno, Disciplina disciplina, double[] notas) {
		aluno.adicionarNotas(disciplina, notas);
	}
	
	public void listarDisciplinasAlunoMedia(Aluno aluno) {
		System.out.println("Disciplinas de " + aluno.getNome());
		for(Disciplina disciplina : aluno.getDisciplinas()) {
			double media = aluno.calcularMedia(disciplina);
			System.out.println(disciplina.getNome() + " - " + media);
		}
	}
	
	public void listarDisciplinaPorGraduação() {
		for(Disciplina disciplina : listaDisciplina) {
			Professor professor = disciplina.getProfessor();
			if(professor.getFormação().equals(EnumFormacao.PÓSGRADUAÇÃO)) {
				System.out.println(disciplina.getNome());
			}
		}
	}
	
	public List<Aluno> listAllAlunos() {
		return listaAlunos;
	}
	
	public List<Professor> listAllProfessores() {
		return listaProfessores;
	}
	
	public List<Disciplina> listAllDisciplinas(){
		return listaDisciplina;
	}
	
	public Aluno getAlunoNome(String nome) {
		return listaAlunos.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
	}
	
	public Disciplina getDisciplinaNome(String nome) {
		return listaDisciplina.stream().filter(disciplina -> disciplina.getNome().equals(nome)).findFirst().orElse(null);
	}
	
}
