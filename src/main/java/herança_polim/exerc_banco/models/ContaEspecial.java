package herança_polim.exerc_banco.models;


public class ContaEspecial extends Conta{
	
	private double limite;
	
	@Override
	public void sacar(double quantidade) {
		
		if (quantidade <= (saldo + limite)) {
			saldo -= quantidade;
			//quanto sobra limite
		}
	}

	public ContaEspecial(int numero, int agencia, String nome, double saldo, double limite) {
		super(numero, agencia, nome, saldo);
		this.limite = limite;
	}
	
}
