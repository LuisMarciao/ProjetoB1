package estruturas;

public class Pilha {
    private No topo;

    public void push(Object valor) {
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public Object pop() {
        if (topo == null) return null;
        Object valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public void exibir() {
        No atual = topo;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}