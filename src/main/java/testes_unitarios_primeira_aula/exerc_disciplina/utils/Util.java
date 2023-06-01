package testes_unitarios_primeira_aula.exerc_disciplina.utils;

import java.util.ArrayList;
import java.util.List;

import testes_unitarios_primeira_aula.exerc_disciplina.enums.EnumFormacao;
import testes_unitarios_primeira_aula.exerc_disciplina.models.Alunos;
import testes_unitarios_primeira_aula.exerc_disciplina.models.Disciplinas;
import testes_unitarios_primeira_aula.exerc_disciplina.models.Professor;

public class Util {

	private List<Professor> listaProfessores = new ArrayList<Professor>();
	private List<Alunos> listaAlunos = new ArrayList<Alunos>();
	private List<Disciplinas> listaDisciplinas = new ArrayList<Disciplinas>();
	
	public Alunos add (Alunos a) {
		listaAlunos.add(a);
		return a;
	}
	
	public Disciplinas add (Disciplinas d) {
		listaDisciplinas.add(d);
		return d;
	}

	public Professor add (Professor p) {
		listaProfessores.add(p);
		return p;
	}
	
	public List<Professor> listAllProfessores() {
		return listaProfessores;
	}
	
	public List<Alunos> listAllAlunos() {
		return listaAlunos;
	}
	
	public List<Disciplinas> listAllDisciplinas() {
		return listaDisciplinas;
	}
		
	public void clearData() {
		listaProfessores.clear();
		listaAlunos.clear();
		listaDisciplinas.clear();
	}
	
	
	public List<Alunos> adicionaDisciplina(Alunos aluno, Disciplinas disciplina) {
		aluno.adicionaDisciplina(disciplina);
		return listaAlunos;
	}
	
	public static void escolherDisciplinas(List<Disciplinas> disciplinas, Alunos aluno,List<Disciplinas> disciplinasEscolhidas) {
			for (Disciplinas disciplina : disciplinasEscolhidas) {
				if (disciplinas.contains(disciplina)) {
					aluno.listDisciplinas().add(disciplina);
				}
			}
	}
	
	public List<Disciplinas> listarPorProfessor(EnumFormacao formação){
		return listaDisciplinas.stream()
				.filter(d -> d.getProfessor().getFormação().equals(formação))
				.toList();
	}
	
	public static void informarNotasAluno(Alunos aluno, Disciplinas disciplina, List<Double> notas) {
		aluno.getNotas().put(disciplina, notas);
	}
	
	public static List<String> listarDisciplinasMedia(Alunos aluno) {
		List<String> disciplinasMedia = new ArrayList<>();

		return disciplinasMedia;
	}
	
}
