package exercicio4;

import java.time.LocalDate;

public non-sealed class CarroPasseio extends Veiculo {

    public CarroPasseio(String placa, String marca, LocalDate anoFabricacao, double valorLocacaoDiaria, double precoFipe) {
        super(placa, marca, anoFabricacao, valorLocacaoDiaria, precoFipe);
    }

    @Override
    public void calcularIpva() {

    }


    @Override
    public void alugarVeiculo(double pesoCarga, LocalDate dataInicio, LocalDate dataFim) {

    }
}
