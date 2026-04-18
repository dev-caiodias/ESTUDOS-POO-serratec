package exercicio4;

import java.time.LocalDate;

public abstract sealed class Veiculo implements  Fretavel, Tributavel permits Caminhao, CarroPasseio{
    protected final String placa;
    protected final String marca;
    protected final LocalDate anoFabricacao;
    protected double valorLocacaoDiaria;
    protected double precoFipe;

    public Veiculo(String placa, String marca, LocalDate anoFabricacao, double valorLocacaoDiaria, double precoFipe) {
        if(placa == null || placa.isBlank()){throw new VeiculoInvalidoException("Placa inválida");}
        if (marca == null || marca.isBlank()) throw new VeiculoInvalidoException("Marca inválida.");
        if (anoFabricacao == null) throw new VeiculoInvalidoException("Ano de fabricação inválido.");
        if (valorLocacaoDiaria <= 0) throw new VeiculoInvalidoException("Valor de locação diária inválido.");
        if (precoFipe <= 0) throw new VeiculoInvalidoException("Preço FIPE deve ser maior que zero.");

        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.precoFipe = precoFipe;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }

    public void setValorLocacaoDiaria(double valorLocacaoDiaria) {
        this.valorLocacaoDiaria = valorLocacaoDiaria;
    }

    public double getPrecoFipe() {
        return precoFipe;
    }

    public void setPrecoFipe(double precoFipe) {
        this.precoFipe = precoFipe;
    }

    public abstract void alugarVeiculo(LocalDate dataInicio, LocalDate dataFim);
}
