package service;

import estruturas.*;
import java.util.Scanner;
import model.*;

public class UnidadeAtendimento {

    private ListaSimples pacientes = new ListaSimples();
    private FilaPrioridade fila = new FilaPrioridade();
    private Pilha historico = new Pilha();
    private ListaDupla prontuarios = new ListaDupla();

    public void cadastrarPaciente(Paciente p) {
        pacientes.adicionar(p);
    }

    public void listarPacientes() {
        pacientes.listar();
    }

    public void chegadaPaciente(String cpf) {
        Paciente p = pacientes.buscarPorCPF(cpf);

        if (p != null) {
            fila.enqueue(p);
            System.out.println("Paciente entrou na fila.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public Paciente chamarProximo() {
        Paciente p = fila.dequeue();

        if (p == null) {
            System.out.println("Fila vazia.");
            return null;
        }

        return p;
    }

    public void finalizarAtendimento(Paciente p, Scanner sc) {
        if (p == null) {
            System.out.println("Nenhum paciente em atendimento.");
            return;
        }

        Atendimento a = new Atendimento(p);
        historico.push(a);

        Prontuario pr = new Prontuario(p);

        System.out.println("Digite sintomas (fim para parar):");
        while (true) {
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("fim")) break;
            pr.adicionarSintoma(s);
        }

        System.out.println("Digite medicamentos (fim para parar):");
        while (true) {
            String m = sc.nextLine();
            if (m.equalsIgnoreCase("fim")) break;
            pr.adicionarMedicamento(m);
        }

        System.out.print("Diagnóstico: ");
        pr.registrarDiagnostico(sc.nextLine());

        prontuarios.adicionar(pr);

        System.out.println("Atendimento finalizado.");
    }

    public void exibirFila() {
        fila.exibir();
    }

    public void exibirHistorico() {
        historico.exibir();
    }

    public void menuProntuarios(Scanner sc) {
        int op;
        do {
            System.out.println("\n1-Ver atual\n2-Próximo\n3-Anterior\n4-Sair");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: prontuarios.exibirAtual(); break;
                case 2: prontuarios.proximo(); break;
                case 3: prontuarios.anterior(); break;
            }
        } while (op != 4);
    }
}