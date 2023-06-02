package refazer_exercicio.medicamento.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import refazer_exercicios.medicamento.enums.EnumAdm;
import refazer_exercicios.medicamento.models.Medicamento;
import refazer_exercicios.medicamento.models.Pessoa;
import refazer_exercicios.medicamento.utils.Consultorio;

public class ConsultorioTest {
	
	Consultorio consultorio = new Consultorio();
	
	@BeforeEach
	void setup() {
		consultorio.getPessoas().clear();
		consultorio.getMedicamentos().clear();
		
		Pessoa pessoa1 = new Pessoa("Pessoa 1", "Gripe");
		pessoa1.addCondicaoSaude("Diabetes");
		pessoa1.addCondicaoSaude("Pressao Alta");
		
		Pessoa pessoa2 = new Pessoa("Pessoa 2", "Dor");
		pessoa2.addCondicaoSaude("Pressao Alta");
		
		Pessoa pessoa3 = new Pessoa("Pessoa 3", "Dengue");
		
		consultorio.cadastraPessoa(pessoa1);
		consultorio.cadastraPessoa(pessoa2);
		consultorio.cadastraPessoa(pessoa3);
		
		Medicamento med1 = new Medicamento("Med 1", EnumAdm.ORAL);
		med1.addIndicacao("Gripe");
		med1.addIndicacao("Dor");
		med1.addContraIndicacao("Diabetes");
		
		Medicamento med2 = new Medicamento("Med 2", EnumAdm.INJETAVEL);
		med2.addIndicacao("Dengue");
		med2.addContraIndicacao("Pressao Alta");
		
		consultorio.cadastraMedicamento(med1);
		consultorio.cadastraMedicamento(med2);
	}
	
	@Test
	@DisplayName("Testa cadastra pessoa")
	void cadastraPessoa() {
		Pessoa pessoa4 = new Pessoa("Pessoa 4", "Dor");
		consultorio.cadastraPessoa(pessoa4);
		assertEquals(4, consultorio.getPessoas().size());
	}
	
	@Test
	@DisplayName("Testa cadastra medicamento")
	void cadastraMedicamento() {
		Medicamento med3 = new Medicamento("Med 3", EnumAdm.ORAL);
		consultorio.cadastraMedicamento(med3);
		assertEquals(3, consultorio.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Testa existe pessoa")
	void testaExistePessoa() {
		consultorio.existePessoa(consultorio.getPessoas().get(0));
		assertEquals("Pessoa 1", consultorio.getPessoas().get(0).getNome());
	}
	
	@Test
	@DisplayName("Testa existe pessoa")
	void testaExisteMedicamento() {
		consultorio.existeMedicamentos(consultorio.getMedicamentos().get(0));
		assertEquals("Med 1", consultorio.getMedicamentos().get(0).getNome());
	}
	
	@Test
	@DisplayName("Testa prescricao certa")
	void testaPrescricaoCerta() {
		Pessoa pessoa = consultorio.getPessoas().get(1);
		Medicamento medicamento = consultorio.getMedicamentos().get(0);
		
		consultorio.prescreve(medicamento, pessoa);
		assertEquals(true, pessoa.getMedicamentos().contains(medicamento));
		assertEquals(1, pessoa.getMedicamentos().size());
		assertEquals("Med 1", pessoa.getMedicamentos().get(0).getNome());
	}
	
	@Test
	@DisplayName("Testa prescricao errada")
	void testaPrescricaoErrada() {
		Pessoa pessoa = consultorio.getPessoas().get(0);
		Medicamento medicamento = consultorio.getMedicamentos().get(0);
		
		consultorio.prescreve(medicamento, pessoa);
		assertEquals(0, pessoa.getMedicamentos().size());
	}
}
