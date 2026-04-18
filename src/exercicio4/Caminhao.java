package exercicio4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public non-sealed class Caminhao extends Veiculo {
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

        System.out.println("O valor total: " + valorTotal);
    }

    @Override
    public void calcularIpva() { // criar toString para os dois
        double ipva;
        long verificacao = ChronoUnit.YEARS.between(anoFabricacao, LocalDate.now());
        if (verificacao > 20){
            ipva = 0;
        }else {
            ipva = precoFipe * 0.015;
        }
    }

}
