package exercicio3;

public final class Cliente {
    private String nome;
    private Endereco endereco;
    private String cpf;


    public Cliente(String nome, Endereco endereco, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }
}
