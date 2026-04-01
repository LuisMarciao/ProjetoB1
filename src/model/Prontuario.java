package model;

import estruturas.ListaSimples;

public class Prontuario {

    private static int contador = 1;

    public int idProntuario;
    public Paciente paciente;

    public ListaSimples sintomas = new ListaSimples();
    public ListaSimples medicamentos = new ListaSimples();

    public String diagnostico;
    public String observacoes;

    public Prontuario(Paciente paciente) {
        this.idProntuario = contador++;
        this.paciente = paciente;
    }

    public void adicionarSintoma(String s) {
        sintomas.adicionar(s);
    }

    public void adicionarMedicamento(String m) {
        medicamentos.adicionar(m);
    }

    public void registrarDiagnostico(String d) {
        this.diagnostico = d;
    }

    public void registrarObservacoes(String o) {
        this.observacoes = o;
    }


    public void exibirProntuario() {
        System.out.println("\n=== PRONTUÁRIO ===");
        System.out.println("ID: " + idProntuario);
        System.out.println("Paciente: " + paciente.nome);

        System.out.println("\nSintomas:");
        sintomas.listar();

        System.out.println("\nMedicamentos:");
        medicamentos.listar();

        System.out.println("\nDiagnóstico: " + diagnostico);
        System.out.println("Observações: " + observacoes);
    }
}