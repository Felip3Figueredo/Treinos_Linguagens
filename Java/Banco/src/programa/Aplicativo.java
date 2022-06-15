package programa;

import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainExceptions;

public class Aplicativo {

	public static void main(String[] args) throws DomainExceptions {
		try {
			
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t\tEntre com os dados da Conta\t\t");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		
		System.out.print("Saldo inicial: ");
		Double saldoInicial = sc.nextDouble();
		
		System.out.print("Limite de saque: ");
		Double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, nome, saldoInicial, limiteSaque);
		
		System.out.print("Digite o valor para saque: ");
		Double valorSaque = sc.nextDouble();
		
		conta.saque(valorSaque);
		
		System.out.println(conta);
		
		sc.close();
		}
		catch(RuntimeException e) {
			System.out.println("Um erro inesperado aconteceu!");
		}
		catch(DomainExceptions e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
