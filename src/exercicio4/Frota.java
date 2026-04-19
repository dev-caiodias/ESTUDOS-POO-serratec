package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculos(Veiculo v){
        veiculos.add(v);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
