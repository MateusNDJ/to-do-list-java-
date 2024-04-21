import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {

    private static List<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    adicionarTarefa(scanner);
                    break;
                case "2":
                    listarTarefas();
                    break;
                case "3":
                    marcarConcluida(scanner);
                    break;
                case "4":
                    System.out.println("Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }

    private static void adicionarTarefa(Scanner scanner) {
        System.out.print("Digite a nova tarefa: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listarTarefas() {
        System.out.println("\nLista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }

    private static void marcarConcluida(Scanner scanner) {
        listarTarefas();
        try {
            System.out.print("Digite o número da tarefa concluída: ");
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            tarefas.remove(indice);
            System.out.println("Tarefa marcada como concluída!");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Entrada inválida. Certifique-se de escolher um número válido.");
        }
    }
}

