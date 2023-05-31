package exemplo_polimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PolimorfismoTest {

	List<Forma> formas = new ArrayList<>();
	
	@BeforeEach
	void setup() {
		formas.add(new Cilindro());
		formas.add(new Circulo());
		formas.add(new Quadrado());
		formas.add(new Triangulo());
	}
	
	@Test
	@DisplayName("Teste desenhar cilindro")
	void desenharCilindro() {
		String s = formas.get(0).desenhar();
		assertEquals("Sou a forma Cilindro", s);
		assertEquals("Cilindro", formas.get(0).getNome());
	}
	
	@Test
	@DisplayName("Teste desenhar circulo")
	void desenharCirculo() {
		String s = formas.get(1).desenhar();
		assertEquals("Sou um circulo e tenho meu próprio desenho", s);
	}
	
	@Test
	@DisplayName("Teste desenhar quadrado")
	void desenharQuadrado() {
		String s = formas.get(2).desenhar();
		assertEquals("Sou a forma Quadrado e tenho 4 lados", s);
	}
	
	@Test
	@DisplayName("Teste desenhar triangulo")
	void desenharTriangulo() {
		String s = formas.get(3).desenhar();
		assertEquals("Sou a forma Triângulo e tenho 3 lados", s);
		if( formas.get(3) instanceof Triangulo) {
			Triangulo t = (Triangulo) formas.get(3);
			assertEquals(2, t.getLados() );
		}
		
	}
	
	@Test
	@DisplayName("Teste area circulo")
	void calculaAreaCirculo() {
		String s = "";
		if( formas.get(1) instanceof Circulo) {
			Circulo c = (Circulo) formas.get(1);
			s = c.calculaArea();
		}
		assertEquals("Minha área pode ser calculada", s);
	}
	
}
