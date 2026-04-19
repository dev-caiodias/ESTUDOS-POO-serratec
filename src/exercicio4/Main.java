package exercicio4;

import exercicio4.Exceptions.VeiculoInvalidoException;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        Frota frota = new Frota();

        try {
            Caminhao caminhao = new Caminhao("EQC-9988", "Mercedes", LocalDate.of(2020, 1, 1), 1000.0, 150000.0, 5.0);
            CarroPasseio carro = new CarroPasseio("XYZ-5678", "Toyota", LocalDate.of(2018, 6, 15), 150.0, 80000.0);

            frota.adicionarVeiculos(caminhao);
            frota.adicionarVeiculos(carro);

        }catch(VeiculoInvalidoException e){
            System.out.println("ERRO ao criar o veiculo " + e.getMessage());
        }

        System.out.println("=== VEÍCULOS DISPONÍVEIS ===\n");
        for (int i = 0; i < frota.getVeiculos().size(); i++) {
            System.out.println("[" + i + "] " + frota.getVeiculos().get(i));
        }

        System.out.println("Escolha o número do veículo: ");
        int escolha = sc.nextInt();
        Veiculo escolhido = frota.getVeiculos().get(escolha);

        try{
            if(escolhido instanceof Caminhao caminhaoEscolhido){
                caminhaoEscolhido.alugarVeiculo(4.0, LocalDate.of(2026, 4, 20), LocalDate.of(2026, 4, 25));
            }else if(escolhido instanceof CarroPasseio carroEscolhido){
                carroEscolhido.alugarVeiculo(LocalDate.of(2026, 4, 20), LocalDate.of(2026, 4, 23));
            }
        }catch(VeiculoInvalidoException e){
            System.out.println("ERRO: " + e.getMessage());
        }

        sc.close();

    }
}
