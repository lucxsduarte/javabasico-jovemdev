package testes_unitarios_primeira_aula.exerc_disciplina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Alunostest {
	
	private Alunos aluno;
	private Disciplinas disciplina;
	
	@BeforeEach
	void init() {
		aluno = new Alunos("João");
		Professor p = new Professor("Prof 1", EnumFormacao.ESPECIALIZAÇÃO);
		disciplina = new Disciplinas("História", 30, p);
		
	}
	
	@Test
	@DisplayName("Testa getNome")
	
	void testGetNome() {
		String nome = aluno.getNome();
		assertEquals("João", nome);
		
	}
	
	@Test
	@DisplayName("TesteGetDisciplina")
	
	void testListDisciplinas() {
		List<Disciplinas> disciplinas = aluno.listDisciplinas();
		Assertions.assertTrue(disciplinas.isEmpty());
		
		disciplinas.add(disciplina);
		assertEquals(1, disciplinas.size());
		assertEquals("História", disciplinas.get(0).getNomeDisciplina());
	}
	
	@Test
	@DisplayName("Testa notas do aluno")
	void testInformaNotas() {
		List<Disciplinas> disciplinas = aluno.listDisciplinas();
		aluno.informaNotas(disciplina);
	}
}
