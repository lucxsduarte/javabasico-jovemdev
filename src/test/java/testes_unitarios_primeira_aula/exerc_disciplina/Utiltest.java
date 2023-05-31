package testes_unitarios_primeira_aula.exerc_disciplina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Utiltest {

	private Util bd = new Util();
	
	@BeforeEach
	void init() {
		bd.clearData();
		Professor p1 = new Professor("Prof 1", EnumFormacao.GRADUAÇÃO);
		Professor p2 = new Professor("Prof 2", EnumFormacao.ESPECIALIZAÇÃO);
		Professor p3 = new Professor("Prof 3", EnumFormacao.PÓSGRADUAÇÃO);
		bd.add(p1);
		bd.add(p2);
		bd.add(p3);
		
		Alunos a1 = new Alunos("Aluno 1");
		Alunos a2 = new Alunos("Aluno 2");
		Alunos a3 = new Alunos("Aluno 3");
		bd.add(a1);
		bd.add(a2);
		bd.add(a3);
		
		Disciplinas d1 = new Disciplinas("Disciplina 1", 30, p1);
		Disciplinas d2 = new Disciplinas("Disciplina 2", 30, p2);
		Disciplinas d3 = new Disciplinas("Disciplina 3", 40, p3);
		bd.add(d1);
		bd.add(d2);
		bd.add(d3);
		
	}
	
	@Test
	@DisplayName("Teste listar alunos")
	
	void testListAllAlunos() {
		List<Alunos> alunos = bd.listAllAlunos();
		assertEquals(3, alunos.size());
		assertEquals("Aluno 1", alunos.get(0).getNome());
		alunos.add(new Alunos("Aluno 4"));
		alunos = bd.listAllAlunos();
		assertEquals(4, alunos.size());
		assertEquals("Aluno 4", alunos.get(3).getNome());
	}
	
	@Test
	@DisplayName("Teste listar professores")
	void testListAllProfessores() {
		List<Professor> professores = bd.listAllProfessores();
		assertEquals(3, professores.size());
		assertEquals("Prof 2", professores.get(1).getNome());
		professores.add(new Professor("Prof 4", EnumFormacao.ESPECIALIZAÇÃO));
		professores = bd.listAllProfessores();
		assertEquals(4, professores.size());
		assertEquals(EnumFormacao.ESPECIALIZAÇÃO, professores.get(3).getFormação());
	}
	
	@Test
	@DisplayName("Teste disciplinas")
	void testListAllDisciplinas() {
		List<Disciplinas> disciplinas = bd.listAllDisciplinas();
		assertEquals(3, disciplinas.size());
		assertEquals(40, disciplinas.get(2).getCargaHoraria());
		Professor p = new Professor("Prof 3", EnumFormacao.PÓSGRADUAÇÃO);
		disciplinas.add(new Disciplinas("Disciplina 4", 45, p));
		disciplinas = bd.listAllDisciplinas();
		assertEquals(45, disciplinas.get(3).getCargaHoraria());
	}
	
	
	@Test
	@DisplayName("Teste adiciona disciplina")
	void testAdicionaDisciplina() {
		List<Alunos> alunos = bd.listAllAlunos();
		List<Disciplinas> disciplinas = bd.listAllDisciplinas();
		List<Professor> professores = bd.listAllProfessores();
		Professor p = new Professor("Prof 4", EnumFormacao.GRADUAÇÃO);
		Alunos a = new Alunos();
		Disciplinas d = new Disciplinas("História", 40, p);
		a.adicionaDisciplina(d);
	}
	
	@Test
	@DisplayName("Lista disciplinas por professor")
	void testListaPorProfessores() {
		List<Disciplinas> disciplinas = bd.listarPorProfessor(EnumFormacao.PÓSGRADUAÇÃO);
		assertEquals(1, disciplinas.size());
	}
}
