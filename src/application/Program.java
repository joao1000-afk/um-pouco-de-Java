package application;

import java.util.Scanner;
import entities.ContaBancaria;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ContaBancaria conta1 = new ContaBancaria();
		ContaBancaria conta2 = new ContaBancaria();

		System.out.println("digite o nome e o saldo da primeira conta");
		conta1.setTitular(sc.nextLine());
		double saldo1 = sc.nextDouble();
		sc.nextLine(); // gasta o /n talvez da pra colocar um try/cacth .
		conta1.definirSaldoInicial(saldo1);

		System.out.println("digite o nome e o saldo da segunda conta");
		conta2.setTitular(sc.nextLine());
		double saldo2 = sc.nextDouble();
		conta2.definirSaldoInicial(saldo2);

		if (conta1.getSaldo() >= 150) {
			conta1.sacar(150);
		}
		if (conta2.getSaldo() >= 0) {
			conta2.depositar(200);
		}

		System.out.println("o saldo da conta de " + conta1.getTitular() + " e de: " + conta1.getSaldo());
		System.out.println("o saldo da conta de " + conta2.getTitular() + " e de: " + conta2.getSaldo());

		sc.close();
	}
}
