package testes_unitarios_primeira_aula.exerc_disciplina;

import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	
	public List<Disciplinas> escolherDisciplina(Alunos aluno) {
		return listaDisciplinas.stream()
				.filter(a -> a.getNomeDisciplina().equals(listaDisciplinas))
				.toList();
		
	}
	
}
