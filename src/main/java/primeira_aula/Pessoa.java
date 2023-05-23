package primeira_aula;

public class Pessoa {

	private String nome;
	private int sexo;
	private double peso;
	private double altura;
	
	public Pessoa(String n, double p, double a, int s) {
		this.nome = n;
		this.peso = p;
		this.altura = a;
		this.sexo = s;
	}
	
	
	public String getNome() {
		return nome;
	}
	public int getSexo() {
		return sexo;
	}
	public double getPeso() {
		return peso;
	}
	public double getAltura() {
		return altura;
	}
	
}
