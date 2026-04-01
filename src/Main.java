import java.util.Scanner;
import model.Paciente;
import service.UnidadeAtendimento;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnidadeAtendimento ua = new UnidadeAtendimento();
        Paciente pacienteAtual = null;

        int opcao;

        do {
            System.out.println("\n1-Cadastrar\n2-Listar\n3-Chegada\n4-Fila\n5-Chamar\n6-Finalizar\n7-Histórico\n8-Prontuários\n9-Sair");

            while (true) {
                try {
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Digite um número válido!");
                    sc.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    int idade;
                    while (true) {
                        System.out.print("Idade: ");
                        try {
                            idade = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Idade inválida!");
                            sc.nextLine();
                        }
                    }

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    String prioridade;
                    while (true) {
                        System.out.print("Prioridade (alta/media/baixa): ");
                        prioridade = sc.nextLine();
                        if (prioridade.equalsIgnoreCase("alta") ||
                            prioridade.equalsIgnoreCase("media") ||
                            prioridade.equalsIgnoreCase("baixa")) break;
                        System.out.println("Digite alta, media ou baixa!");
                    }

                    ua.cadastrarPaciente(new Paciente(nome, idade, cpf, prioridade));
                    break;

                case 2:
                    ua.listarPacientes();
                    break;

                case 3:
                    System.out.print("CPF: ");
                    ua.chegadaPaciente(sc.nextLine());
                    break;

                case 4:
                    ua.exibirFila();
                    break;

                case 5:
                    if (pacienteAtual != null) {
                        System.out.println("Já existe um paciente em atendimento!");
                    } else {
                        pacienteAtual = ua.chamarProximo();
                        System.out.println("Chamado: " + pacienteAtual);
                    }
                    break;

                case 6:
                    if (pacienteAtual == null) {
                        System.out.println("Nenhum paciente em atendimento!");
                    } else {
                        ua.finalizarAtendimento(pacienteAtual, sc);
                        pacienteAtual = null;
                    }
                    break;

                case 7:
                    ua.exibirHistorico();
                    break;

                case 8:
                    ua.menuProntuarios(sc);
                    break;
            }

        } while (opcao != 9);

        sc.close();
    }
}