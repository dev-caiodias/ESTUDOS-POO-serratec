package exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 10000;
        int escolha;
        double valorDepositado;
        double valorSaque;
        int valorMaximoSaque = 1000;
        int quantidadeSaque = 0;

        do{
            System.out.println("\n\n====SISTEMA DE CAIXA ELETRÔNICO====");
            System.out.println("""
                    [1] VER SALDO
                    [2] DEPOSITAR
                    [3] SACAR
                    [4] SAIR
                    ESCOLHA: """);

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    System.out.printf("SALDO ATUAL: %.2f", saldo);
                    break;

                case 2:
                    System.out.println("Quanto deseja depositar? ");
                    valorDepositado = scanner.nextDouble();
                    scanner.nextLine();

                    saldo += valorDepositado;
                    System.out.printf("SALDO ATUAL: %.2f", saldo);
                    break;

                case 3:
                    quantidadeSaque++;
                    if(quantidadeSaque > 3){
                        System.out.println("Limite de saque diário atinfido!");
                        break;
                    }else{
                        System.out.println("Quanto deseja sacar? ");
                        valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        if (valorSaque > valorMaximoSaque){
                            System.out.println("Operação bloqueada por segurança. Digite um valor menor do que 1000.");
                            valorSaque = scanner.nextDouble();
                            scanner.nextLine();
                        }

                        saldo-=valorSaque;
                        System.out.printf("SALDO ATUAL: %.2f", saldo);
                        break;
                    }
            }
        }while(escolha != 4 );

        scanner.close();
        System.out.println("\nPROGRAMA FINALIZADO");
    }
}