package modelo.entidades;

import modelo.excecao.SaldoInsuficienteException;

public class Conta {

	private Integer numeroDaConta;
	private String titularDaConta;
	private Double saldoDaConta;
	private Double limiteDeSaque;

	public Conta() {

	}

	public Conta(Integer numeroDaConta, String titularDaConta, Double saldoDaConta, Double limiteDeSaque) {

		this.numeroDaConta = numeroDaConta;
		this.titularDaConta = titularDaConta;
		this.saldoDaConta = saldoDaConta;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}

	public Double getSaldoDaConta() {
		return saldoDaConta;
	}

	public void deposito(double valorDeposito) {

		this.saldoDaConta += valorDeposito;
	}

	public void saque(double valorSaque) {

		if (saldoDaConta < valorSaque) {
			throw new SaldoInsuficienteException("Saldo insuficiente.");
			
		} else if (valorSaque > limiteDeSaque) {
			throw new SaldoInsuficienteException("Saque não realizado: Valor do saque superior ao limite de saque.");
			
		} else {
			this.saldoDaConta -= valorSaque;
		}

	}

	@Override
	public String toString() {
		return "Número da conta: " + getNumeroDaConta() + "\n Titular da conta: " + getTitularDaConta()
				+ "\n saldo da conta R$: " + String.format("%.2f", getSaldoDaConta()) + "\n limite de saque R$: "
				+ String.format("%.2f", getLimiteDeSaque());
	}

}
