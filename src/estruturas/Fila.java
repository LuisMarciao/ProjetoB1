package estruturas;

public class Fila {
    private No inicio;
    private No fim;

    public void enqueue(Object valor) {
        No novo = new No(valor);
        if (fim == null) inicio = fim = novo;
        else { fim.proximo = novo; fim = novo; }
    }

    public Object dequeue() {
        if (inicio == null) return null;
        Object valor = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return valor;
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}