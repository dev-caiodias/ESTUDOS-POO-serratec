package exercicio3;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item){
        itens.add(item);
    }

    private double calcularTotal(){
        double valorTotal = 0;

        for (ItemPedido item : itens) {
            valorTotal += item.getSubTotal();
        }

        return valorTotal;
    }

    private double calcularFrete(double valorTotal){
        if (valorTotal >= 250){
             return 0;
        }else{
            return 25;
        }
    }

    public void fecharPedido(){
        double valorTotal = calcularTotal();
        double frete = calcularFrete(valorTotal);

        StringBuilder sb = new StringBuilder("===RECIBO===\n\n");
        sb.append("--> DADOS DO CLIENTE <--\n");
        sb.append("Nome: ").append(cliente.getNome()).append("\n");
        sb.append("CPF: ").append(cliente.getCpf()).append("\n");

        sb.append("-->ENTREGA<--\n");
        sb.append("Endereço: ").append(cliente.getEndereco().rua()).append("\n")
                .append(" Bairro").append(cliente.getEndereco().bairro()).append("\n");
        sb.append("Cidade: ").append(cliente.getEndereco().cidade()).append("\n");

        sb.append("Itens: \n");
        for (ItemPedido item : itens){
            sb.append(item.getNomeProduto())
                    .append(" - ")
                    .append(item.getPrecoUnitario())
                    .append(" x ")
                    .append(item.getQuantidade())
                    .append(" = ")
                    .append(item.getSubTotal())
                    .append("\n")  ;
        }

        sb.append("\n");

        sb.append("TOTAL: R$ ").append(valorTotal).append("\n");
        sb.append("Frete: R$" ).append(frete);
        sb.append("Total final: ").append(valorTotal + frete).append("\n");

        System.out.println(sb.toString());
    }
}
