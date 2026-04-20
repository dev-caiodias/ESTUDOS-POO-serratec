package exercicio4;

import exercicio4.Exceptions.VeiculoInvalidoException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

        // objetos para testar exceções do construtor de Veículo

    // TESTE 1 - Placa nula
    // try {
    //     Caminhao c1 = new Caminhao(null, "Mercedes", LocalDate.of(2020, 1, 1), 1000.0, 150000.0, 5.0);
    //     frota.adicionarVeiculos(c1);
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 2 - Marca em branco
    // try {
    //     Caminhao c2 = new Caminhao("EQC-9988", "", LocalDate.of(2020, 1, 1), 1000.0, 150000.0, 5.0);
    //     frota.adicionarVeiculos(c2);
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 3 - Ano de fabricação nulo
    // try {
    //     Caminhao c3 = new Caminhao("EQC-9988", "Mercedes", null, 1000.0, 150000.0, 5.0);
    //     frota.adicionarVeiculos(c3);
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 4 - Valor de diária inválido
    // try {
    //     CarroPasseio cp1 = new CarroPasseio("XYZ-5678", "Toyota", LocalDate.of(2018, 6, 15), -150.0, 80000.0);
    //     frota.adicionarVeiculos(c4);
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 5 - Preço FIPE inválido
    // try {
    //     CarroPasseio cp2 = new CarroPasseio("XYZ-5678", "Toyota", LocalDate.of(2018, 6, 15), 150.0, 0);
    //     frota.adicionarVeiculos(c5);
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 6 - Peso da carga inválido
    // try {
    //     Caminhao c4 = new Caminhao("EQC-9988", "Mercedes", LocalDate.of(2020, 1, 1), 1000.0, 150000.0, 5.0);
    //     c4.alugarVeiculo(-1.0, LocalDate.of(2026, 4, 20), LocalDate.of(2026, 4, 25));
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

    // TESTE 7 - Data fim antes da data início
    // try {
    //     CarroPasseio cp3 = new CarroPasseio("XYZ-5678", "Toyota", LocalDate.of(2018, 6, 15), 150.0, 80000.0);
    //     cp3.alugarVeiculo(LocalDate.of(2026, 4, 25), LocalDate.of(2026, 4, 20));
    // } catch (VeiculoInvalidoException e) {
    //     System.out.println("ERRO: " + e.getMessage());
    // }

        System.out.println("=== VEÍCULOS DISPONÍVEIS ===\n");
        for (int i = 0; i < frota.getVeiculos().size(); i++) {
            System.out.println("[" + i + "] " + frota.getVeiculos().get(i));
        }

        System.out.println("Escolha o número do veículo: ");
        int escolha = sc.nextInt();
        Veiculo escolhido = frota.getVeiculos().get(escolha);

        try{
            System.out.println("Data início: ");
            LocalDate dataInicio = LocalDate.parse(sc.next());
            System.out.println("Data retorno: ");
            LocalDate dataFim = LocalDate.parse(sc.next());

            if(escolhido instanceof Caminhao caminhaoEscolhido){
                System.out.println("Peso da carga: ");
                double peso = sc.nextDouble();
                caminhaoEscolhido.alugarVeiculo(peso, dataInicio, dataFim);
            }else if(escolhido instanceof CarroPasseio carroEscolhido){
                carroEscolhido.alugarVeiculo(dataInicio, dataFim);
            }
        }catch(DateTimeParseException e){
            System.out.println("ERRO: Data inválida.");
        }catch(VeiculoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
