package estruturas;

import model.Paciente;

public class ListaSimples {
    private No inicio;

    public void adicionar(Object valor) {
        No novo = new No(valor);
        if (inicio == null) inicio = novo;
        else {
            No atual = inicio;
            while (atual.proximo != null) atual = atual.proximo;
            atual.proximo = novo;
        }
    }

    public void listar() {
        No atual = inicio;
        while (atual != null) {
            System.out.println("- " + atual.valor);
            atual = atual.proximo;
        }
    }

    public Paciente buscarPorCPF(String cpf) {
        No atual = inicio;
        while (atual != null) {
            Paciente p = (Paciente) atual.valor;
            if (p.cpf.equals(cpf)) return p;
            atual = atual.proximo;
        }
        return null;
    }
}