package exercicio2;

public class contaBancaria {

    private int numeroConta;
    private String titular;
    private double saldo;

    private int valorMaximoSaque = 1000;
    private int quantidadeSaque = 0;

    //CONSTRUTOR
    public contaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 50;
    }

    //MÉTODOS DE FUNCIONALIDADES
    public void verSaldo(){
        System.out.printf("SALDO ATUAL: %.2f", saldo);
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){

        if(quantidadeSaque > 3){
            System.out.println("Limite de saque atingido!");
            return;
        }
        if(valor > valorMaximoSaque){
            System.out.println("Bloqueamos sua transação. Valor acima do limite!");
            return;
        }
        if (valor > saldo){
            System.out.println("Saldo insuficiente!");
            return;
        }

        saldo-=valor;
        quantidadeSaque++;
    }
}

