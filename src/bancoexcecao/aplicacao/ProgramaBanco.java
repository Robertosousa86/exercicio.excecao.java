package bancoexcecao.aplicacao;

import java.util.Scanner;

import modelo.entidades.Conta;
import modelo.excecao.SaldoInsuficienteException;

public class ProgramaBanco {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("===DIGITE OS DADOS DA CONTA===");
			System.out.print("Número da conta: ");
			int numeroDaConta = sc.nextInt();
			System.out.print("Titular da conta: ");
			String titularDaConta = sc.next();
			System.out.print("Saldo inicial R$: ");
			double saldoDaConta = sc.nextDouble();
			System.out.print("Limite de saque R$: ");
			double limiteDeSaque = sc.nextDouble();

			Conta conta = new Conta(numeroDaConta, titularDaConta, saldoDaConta, limiteDeSaque);
			System.out.println("SALDO INICIAL R$: " + String.format("%.2f", conta.getSaldoDaConta()));

			System.out.print("Digite o valor do saque: ");
			double valorSaque = sc.nextDouble();
			conta.saque(valorSaque);
			System.out.println(conta);

		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			
		} catch (RuntimeException e) {
			System.out.println("Desculpe, houve um erro inesperado.");
		}

		sc.close();

	}

}
