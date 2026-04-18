package exercicio4;

import java.time.LocalDate;

public interface Fretavel {
    void alugarVeiculo(double pesoCarga, LocalDate dataInicio, LocalDate dataFim);
}
