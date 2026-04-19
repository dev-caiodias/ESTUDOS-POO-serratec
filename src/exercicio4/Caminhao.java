package exercicio4;

import exercicio4.Exceptions.VeiculoInvalidoException;
import exercicio4.Interfaces.FretavelComCarga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public non-sealed class Caminhao extends Veiculo implements FretavelComCarga {
    protected double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, LocalDate anoFabricacao, double valorLocacaoDiaria, double precoFipe, double capacidadeCargaToneladas) {
        super(placa, marca, anoFabricacao, valorLocacaoDiaria, precoFipe);
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    public double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }

    private double calculaCarga(double pesoCarga){
        if (pesoCarga > capacidadeCargaToneladas){
            return valorLocacaoDiaria + (valorLocacaoDiaria * 0.10);
        }else {
            return valorLocacaoDiaria;
        }
    }

    @Override
    public void alugarVeiculo(double pesoCarga, LocalDate dataInicio, LocalDate dataFim) {

        if(pesoCarga <= 0){throw new VeiculoInvalidoException("Peso da carga inválido.");}
        if(dataInicio == null || dataFim == null){throw new VeiculoInvalidoException("Dias inválidos.");}
        if(dataFim.isBefore(dataInicio)){throw new VeiculoInvalidoException("A data final não pode anteceder a data inicial");}

        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        double valorDiaria = calculaCarga(pesoCarga);
        double valorTotal = valorDiaria * dias;

        GeradorArquivo.gerarRecibo(this, dataInicio, dataFim, valorTotal);
    }

    @Override
    public double calcularIpva() { // criar toString para os dois
        double ipva;
        long verificacao = ChronoUnit.YEARS.between(anoFabricacao, LocalDate.now());
        if (verificacao > 20){
           return ipva = 0;
        }else {
            return ipva = precoFipe * 0.015;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==== CAMINHÃO ====\n\n");
        sb.append("Placa: ").append(placa).append("\n");
        sb.append("Marca: ").append(marca).append("\n");
        sb.append("Ano Fabricação: ").append(anoFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        sb.append("Capacidade: ").append(capacidadeCargaToneladas).append("\n");
        sb.append("\n--- Valores ---\n");
        sb.append("Diária: R$ ").append(String.format("%.2f ", valorLocacaoDiaria)).append("\n");
        sb.append("Preço Fipe: R$ ").append(String.format("%.2f", precoFipe)).append("\n");
        sb.append("IPVA: R$ ").append(String.format("%.2f", calcularIpva())).append("\n");
        sb.append("\n================================\n");
        return sb.toString();
    }

    @Override
    public void alugarVeiculo(LocalDate dataInicio, LocalDate dataFim) {

    }
}
