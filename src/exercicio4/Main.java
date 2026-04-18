package exercicio4;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

        }catch(VeiculoInvalidoException e){
            System.out.println("ERRO: " + e.getMessage());
        }

    }
}
