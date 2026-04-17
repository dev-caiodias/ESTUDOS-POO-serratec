package exercicio3;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("R. Virgilio de Melo Franco", "Rio de Janeiro", "Gramacho");
        Cliente cliente = new Cliente("Caio", endereco, "14205704712");

        ItemPedido item1 = new ItemPedido("Mouse gamer", 2, 147.50);
        ItemPedido item2 = new ItemPedido("Teclado mecânico", 1, 299.90);
        ItemPedido item3 = new ItemPedido("Headset", 1, 189.99);
        ItemPedido item4 = new ItemPedido("Mousepad XL", 3, 59.90);
        ItemPedido item5 = new ItemPedido("Webcam HD", 1, 219.00);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);
        pedido.adicionarItem(item4);
        pedido.adicionarItem(item5);

        pedido.fecharPedido();

    }
}
