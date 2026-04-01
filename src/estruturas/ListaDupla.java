package estruturas;

import model.Prontuario;

public class ListaDupla {

    private NoDuplo inicio;
    private NoDuplo atual;

    public void adicionar(Object valor) {
        NoDuplo novo = new NoDuplo(valor);

        if (inicio == null) {
            inicio = novo;
            atual = inicio;
            return;
        }

        NoDuplo temp = inicio;
        while (temp.proximo != null) temp = temp.proximo;

        temp.proximo = novo;
        novo.anterior = temp;
    }

    public void exibirAtual() {
        if (atual != null) {
            ((Prontuario) atual.valor).exibirProntuario();
        } else {
            System.out.println("Nenhum prontuário.");
        }
    }

    public void proximo() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            exibirAtual();
        } else {
            System.out.println("Não há próximo.");
        }
    }

    public void anterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            exibirAtual();
        } else {
            System.out.println("Não há anterior.");
        }
    }
}