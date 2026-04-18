package exercicio4;

public class Main {
    public static void main(String[] args) {

        try {
            Caminhao caminhao = new Caminhao("EQC-9988", "MERCEDEZ", 2023, 1000, 0, 5000);

        }catch(VeiculoInvalidoException e){
            System.out.println("ERRO: " + e.getMessage());
        }

    }
}
