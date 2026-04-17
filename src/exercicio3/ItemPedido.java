package exercicio3;

public class ItemPedido {
    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String nomeProduto, int quantidade, double precoUnitario) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double getSubTotal() {
        return quantidade * precoUnitario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
