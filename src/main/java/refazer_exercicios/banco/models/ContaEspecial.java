package refazer_exercicios.banco.models;


public class ContaEspecial extends Conta{
	
	private double limite;
	
	public ContaEspecial(int numero, int agencia, String nomeCorrentista, double saldo, double limite) {
		super(numero, agencia, nomeCorrentista, saldo);
		this.limite = limite;
	}

	@Override
	public boolean sacar(double valor) {
		if(valor <= getSaldo() + limite) {
			saldo = getSaldo() - valor;
			return true;
		}
		return false;
	}
	
}
