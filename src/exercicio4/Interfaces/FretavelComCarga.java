package exercicio4.Interfaces;

import java.time.LocalDate;

public interface FretavelComCarga extends Fretavel {
    void alugarVeiculo(double pesoCarga, LocalDate dataInicio, LocalDate dataFim);
}
