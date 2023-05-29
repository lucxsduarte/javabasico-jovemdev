package testes_unitarios_primeira_aula.exerc_disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Util {

	private List<Professor> listaProfessores = new ArrayList<Professor>();
	private List<Alunos> listaAlunos = new ArrayList<Alunos>();
	private List<Disciplinas> listaDisciplinas = new ArrayList<Disciplinas>();
	
	public Professor add (Professor p) {
		p.setNome(p.getNome());
		listaProfessores.add(p);
		return p;
	}
	
	public List<Professor> listAllProfessores() {
		return listaProfessores;
	}
	
	public Alunos add (Alunos a) {
		a.setNome(a.getNome());
		listaAlunos.add(a);
		return a;
	}
	
	public List<Alunos> listAllAlunos() {
		return listaAlunos;
	}
	
	public Disciplinas add (Disciplinas d) {
		d.setNomeDisciplina(d.getNomeDisciplina());
		listaDisciplinas.add(d);
		return d;
	}
	
	public List<Disciplinas> listAllDisciplinas() {
		return listaDisciplinas;
	}
	
	public List<Professor> findByFormacao(EnumFormacao formação) {
		return listaProfessores.stream()
				.filter( p -> p.getFormação().equals(formação))
				.toList();
	}
	
	
}
