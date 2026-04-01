package model;

public class Paciente {
    private static int contador = 1;

    public int id;
    public String nome;
    public int idade;
    public String cpf;
    public String prioridade;

    public Paciente(String nome, int idade, String cpf, String prioridade) {
        this.id = contador++;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prioridade = prioridade;
    }

    public String toString() {
        return "[" + id + "] " + nome + " (" + prioridade + ")";
    }
}