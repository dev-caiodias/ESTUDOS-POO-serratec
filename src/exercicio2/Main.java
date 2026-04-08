package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número da conta: ");

        int numeroDigitado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nome do titular: ");
        String nome = scanner.nextLine();

        contaBancaria conta = new contaBancaria (numeroDigitado, nome);

        int escolha;

        do{
            System.out.println("CONTA"+ conta.getNumeroConta() +" CRIADA\n");
            System.out.printf("Olá, %s !\n", conta.getTitular());
            System.out.println("====SISTEMA DE CAIXA ELETRÔNICO====\n");
            System.out.println("""
                    O que deseja fazer?
                    [1] VER SALDO
                    [2] DEPOSITAR
                    [3] SACAR
                    [4] SAIR
                    ESCOLHA:""");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                 case 1:
                    conta.verSaldo();
                    break;

                case 2:
                    System.out.println("Valor para depositar: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    conta.verSaldo();
                    break;

                case 3:
                    System.out.println("Valor para sacar: ");
                    double saque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.sacar(saque);
                    conta.verSaldo();
                    break;
            }

        }while(escolha != 4 );

        System.out.println("OBRIGADO PELA PREFERÊNCIA!");
    }
}
