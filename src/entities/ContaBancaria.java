package entities;

public class ContaBancaria {

	private String nomeDoTitular;
	private double saldoDaConta;
	
	public String getTitular() {
		return nomeDoTitular;
	}
	public void setTitular(String nomeDoTitular ) {
		this.nomeDoTitular = nomeDoTitular;
	}
	public Double getSaldo() {
		return saldoDaConta;
	}
	public void definirSaldoInicial(double valor ) {
		if (valor>=0) {
			saldoDaConta = valor;
		} else {
			System.out.println("erro");
		}
	}
	
	public boolean sacar(double valor) {
		if (valor>=0 && saldoDaConta >= valor) {
			saldoDaConta -= valor;
			return true;
		}
		return false;
	}

	public void depositar(double valor) {
		if (valor>0) {
		saldoDaConta += valor;
		}
	}

}
