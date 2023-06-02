package refazer_exercicio.disciplina.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import refazer_exercicios.disciplina.enums.EnumFormacao;
import refazer_exercicios.disciplina.models.Aluno;
import refazer_exercicios.disciplina.models.Disciplina;
import refazer_exercicios.disciplina.models.Professor;
import refazer_exercicios.disciplina.utils.Escola;

public class EscolaTest {
	
	public final Escola escola = new Escola();
	
	@BeforeEach
	public void setup() {
		escola.getListaAlunos().clear();
		escola.getListaDisciplina().clear();
		escola.getListaProfessores().clear();
		
		Professor p1 = new Professor("Prof 1", EnumFormacao.GRADUAÇÃO);
		Professor p2 = new Professor("Prof 2", EnumFormacao.ESPECIALIZAÇÃO);
		Professor p3 = new Professor("Prof 3", EnumFormacao.POSGRADUAÇÃO);
		
		escola.cadastraProfessor(p1);
		escola.cadastraProfessor(p2);
		escola.cadastraProfessor(p3);
		
		Disciplina d1 = new Disciplina("Disciplina 1", 60, p1);
		Disciplina d2 = new Disciplina("Disciplina 2", 40, p2);
		Disciplina d3 = new Disciplina("Disciplina 3", 20, p3);
		escola.cadastraDisciplina(d1);
		escola.cadastraDisciplina(d2);
		escola.cadastraDisciplina(d3);

		Aluno a1 = new Aluno("Aluno 1");
		Aluno a2 = new Aluno("Aluno 2");
		escola.cadastraAluno(a1);
		escola.cadastraAluno(a2);
	}
	
	@Test
	@DisplayName("Teste cadastro professor")
	void testeCadastraProfessor() {
		List<Professor> lista = escola.listAllProfessores();
		assertEquals(3, lista.size());
		
		Professor p4 = new Professor("Prof 4", EnumFormacao.ESPECIALIZAÇÃO);
		lista.add(p4);
		lista = escola.listAllProfessores();
		assertEquals(4,  lista.size());
		assertEquals("Prof 4", lista.get(3).getNome());
	}
	
	@Test
	@DisplayName("Teste cadastra Aluno")
	void testeCadastraAluno() {
		List<Aluno> lista = escola.listAllAlunos();
		assertEquals(2, lista.size());
		
		Aluno a3 = new Aluno("Aluno 3");
		lista.add(a3);
		assertEquals("Aluno 3", lista.get(2).getNome());
	}
	
	@Test
	@DisplayName("teste cadastro disciplina")
	void testeCadastraDisciplina() {
		List<Disciplina> lista = escola.listAllDisciplinas();
		assertEquals(3, lista.size());
		
		Disciplina d4 = new Disciplina("Disciplina 4", 30, escola.listAllProfessores().get(2));
		lista.add(d4);
		assertEquals(4, lista.size());
		assertEquals("Disciplina 4", lista.get(3).getNome());
	}
	
	@Test
	@DisplayName("teste buscar aluno por nome")
	void testeBuscaAluno() {
		Aluno a = escola.getAlunoNome("Aluno 1");
		assertEquals("Aluno 1", a.getNome());
	}
	
	@Test
	@DisplayName("teste buscar disciplina por nome")
	void testeBuscaDisciplina() {
		Disciplina d = escola.getDisciplinaNome("Disciplina 3");
		assertEquals("Disciplina 3", d.getNome());
		assertEquals(20, d.getCargaHoraria());
	}
	
	@Test
	@DisplayName("teste add disciplina aluno")
	void testeAddDisciplinaAluno() {
		Disciplina disciplina = escola.listAllDisciplinas().get(0);
		Aluno aluno = escola.listAllAlunos().get(0);
		
		escola.matricularAluno(aluno, disciplina);
		assertEquals("Disciplina 1", aluno.getDisciplinas().get(0).getNome());
	}
	
	@Test
	@DisplayName("teste informar notas")
	void testeInformarNotas() {
		Disciplina d1 = escola.listAllDisciplinas().get(1);
		Disciplina d2 = escola.listAllDisciplinas().get(2);
		Aluno a = escola.listAllAlunos().get(0);
		
		escola.matricularAluno(a, d2);
		escola.matricularAluno(a, d1);
		
		double[] notasAlunoD1 = {8.0, 6.6, 7.0};
		double[] notasAlunoD2 = {8, 8, 8};
		
		escola.informarNotas(a, d1, notasAlunoD1);
		escola.informarNotas(a, d2, notasAlunoD2);
		
		assertEquals(6.6, a.getNotas().get(d2)[1]);
		assertEquals(8, a.getNotas().get(d2)[2]);
	}
	
	@Test
	@DisplayName("teste listar disciplinas de aluno e media")
	void testaListaDisciplinaAlunoMedia() {
		Disciplina d1 = escola.listAllDisciplinas().get(1);
		Disciplina d2 = escola.listAllDisciplinas().get(2);
		Aluno a = escola.listAllAlunos().get(1);
		
		escola.matricularAluno(a, d1);
		escola.matricularAluno(a, d2);
		
		double[] notasAlunoD1 = {8, 8, 8};
		double [] notasAlunoD2 = {9, 9, 9};
		
		escola.informarNotas(a, d1, notasAlunoD1);
		escola.informarNotas(a, d2, notasAlunoD2);
		
		escola.listarDisciplinasAlunoMedia(a);
		assertTrue(a.getDisciplinas().contains(d1));
		assertTrue(a.getDisciplinas().contains(d2));
	}
	
	@Test
	@DisplayName("teste listar disciplinas com professores com pos graduaçao")
	void testaListaProfComPosGraduação() {
		escola.listarDisciplinaPorGraduação();
	}
	
}
