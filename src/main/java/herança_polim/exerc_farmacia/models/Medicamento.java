package herança_polim.exerc_farmacia.models;


public class Medicamento extends Produto{
	private boolean reterReceita;
	
	public Medicamento(String nome, int estoque, double preço, boolean reterReceita) {
		super(nome, estoque, preço);
		this.reterReceita = reterReceita;
	}
	
	public boolean reterReceita() {
		return reterReceita;
	}
	
	@Override
	public boolean foiVendido(Produto produto, Cliente cliente, int quantidade) {
		if(estoque >= quantidade) {
			if( produto instanceof Medicamento) {
				if(((Medicamento) produto).reterReceita()) {
					String ret = "Nome Médico?";
					estoque -= quantidade;
					cliente.adicionaDivida(produto.getPreço() * quantidade);
					System.out.println(ret);
					return true;
				}else {
					estoque -= quantidade;
					cliente.adicionaDivida(produto.getPreço() * quantidade);
					return true;
				}
			}
		}
		return false;
	}
}
