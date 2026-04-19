package exercicio4;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GeradorArquivo {

    public static void gerarRecibo(Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, double valorTotal){
        String nomeArquivo = "recibo" + veiculo.getPlaca() + ".txt";

        try(FileWriter fw = new FileWriter(nomeArquivo)){
            fw.write(veiculo.toString());
            fw.write("Periodo: " + dataInicio + "--" + dataFim + "\n");
            fw.write("Valor total: R$" + String.format("%.2f", valorTotal) + "\n");
            System.out.println("Arquivo gerado com suceeso! Arquivo: " + nomeArquivo + ".txt");
        } catch (IOException e) {
            System.out.println("ERRO: houve um erro ao gerar o recibo." + e.getMessage());
        }
    }
}
