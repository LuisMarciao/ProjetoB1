package estruturas;

import model.Paciente;

public class FilaPrioridade {

    private Fila alta = new Fila();
    private Fila media = new Fila();
    private Fila baixa = new Fila();

    public void enqueue(Paciente p) {
        if (p.prioridade.equalsIgnoreCase("alta")) alta.enqueue(p);
        else if (p.prioridade.equalsIgnoreCase("media")) media.enqueue(p);
        else baixa.enqueue(p);
    }

    public Paciente dequeue() {
        Paciente p = (Paciente) alta.dequeue();
        if (p != null) return p;
        p = (Paciente) media.dequeue();
        if (p != null) return p;
        return (Paciente) baixa.dequeue();
    }

    public void exibir() {
        System.out.println("=== ALTA ==="); alta.exibir();
        System.out.println("=== MÉDIA ==="); media.exibir();
        System.out.println("=== BAIXA ==="); baixa.exibir();
    }
}