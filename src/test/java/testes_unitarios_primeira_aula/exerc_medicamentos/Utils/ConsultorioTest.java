package testes_unitarios_primeira_aula.exerc_medicamentos.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testes_unitarios_primeira_aula.exerc_medicamentos.enums.EnumAdm;
import testes_unitarios_primeira_aula.exerc_medicamentos.models.Medicamento;
import testes_unitarios_primeira_aula.exerc_medicamentos.models.Pessoa;

public class ConsultorioTest {

	Consultorio consultorio = new Consultorio();
	
	@BeforeEach
	void setup() {
		consultorio.getMedicamentos().clear();
		consultorio.getPessoas().clear();
			Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
			p1.addCondicaoSaude("Diabetes");
			p1.addCondicaoSaude("Pressão Alta");
			
			Pessoa p2 = new Pessoa("Pessoa 2", "Dor");
			p2.addCondicaoSaude("Pressão Alta");
			
			Pessoa p3 = new Pessoa("Pessoa 3", "Dengue");
			
			consultorio.getPessoas().add(p1);
			consultorio.getPessoas().add(p2);
			consultorio.getPessoas().add(p3);
			
			Medicamento m1 = new Medicamento("Medicamento 1", EnumAdm.ORAL);
			m1.addIndicacao("Dor");
			m1.addIndicacao("Febre");
			m1.addContraIndicacoes("Diabetes");
			
			Medicamento m2 = new Medicamento("Medicamento 2", EnumAdm.ORAL);
			m2.addIndicacao("Gripe");
			
			consultorio.getMedicamentos().add(m1);
			consultorio.getMedicamentos().add(m2);
			
	}
	
	@Test
	@DisplayName("Teste cadastrar medicamentos")
	void addMedicamentos() {
		Medicamento m = new Medicamento("Teste 1", EnumAdm.ORAL);
		consultorio.cadastraMedicamento(m);
		assertEquals(3, consultorio.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Teste cadastrar pessoa")
	void addPessoas() {
		Pessoa p = new Pessoa("Pessoa Teste", "");
		consultorio.cadastraPesoa(p);
		assertEquals(4, consultorio.getPessoas().size());
	}
	
	@Test
	@DisplayName("Teste prescricao")
	void addPrescricao() {
		Pessoa p = consultorio.getPessoas().get(1);
		Medicamento m = consultorio.getMedicamentos().get(0);
		consultorio.prescreveMedicamento(p, m);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Medicamento 1", p.getMedicamentos().get(0).getNome());
	}
	
	@Test
	@DisplayName("Teste prescricao falha")
	void addPrescricaoFalha() {
		Pessoa p = consultorio.getPessoas().get(0);
		Medicamento m = consultorio.getMedicamentos().get(0);
		consultorio.prescreveMedicamento(p, m);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Teste para cadastrar pessoa inválida")
	void addPessoaInvalida() {
		List<Pessoa> pessoas = new ArrayList<>();
		
	}
	
	@Test
	@DisplayName("Teste existe pessoa")
	void existePessoas() {
		Pessoa p = consultorio.getPessoas().get(2);
		assertTrue(consultorio.existePessoa(p));
	}
	
	@Test
	@DisplayName("Teste medicamentos")
	void existeMedicamento() {
		Medicamento m = consultorio.getMedicamentos().get(1);
		assertTrue(consultorio.existeMedicamento(m));
	}
	
}
