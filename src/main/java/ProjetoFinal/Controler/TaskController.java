package ProjetoFinal.Controler;

import ProjetoFinal.Domain.BaseTask;
import ProjetoFinal.Domain.PersonalTask;
import ProjetoFinal.Domain.StudyTask;
import ProjetoFinal.Domain.WorkTask;
import ProjetoFinal.Service.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskController {
    //função da classe controller - imprime o menu, recebe input do usuário e passa a requisição para service;
    private final TaskService service = new TaskService();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        String option = "";
        while (!option.equals("0")) {
            showMenu();
            option = getUserOption();
            executeOption(option);
        }
    }

    private void showMenu() {
        String menu = """
                ______ Menu Principal _____
                |0 - Sair                 |
                |1 - Listar tarefas       |
                |2 - Listar uma tarefa    |
                |3 - Atualizar uma tarefa |
                |4 - Apagar uma tarefa    |
                |5 - Criar uma tarefa     |
                '''''''''''''''''''''''''''
                """;
        System.out.println(menu);
    }

    private String getUserOption() {
        System.out.print("Escolha uma opção acima: ");
        return scanner.nextLine();
    }

    private void executeOption(String option) {
        switch (option) {
            case "0":
                System.out.println("Sair do Menu");
                break;
            case "1":
                listTasks();
                break;
            case "2":
                listOneTask();
                break;
            case "3":
                updateTask();
                break;
            case "4":
                deleteTask();
                break;
            case "5":
                createTasks();
                break;
            default:
                System.out.println("Falha");
        }
    }

    private void createTasks() {
        String subMenu = """
                __ Tipos de Tarefas __
                | 0 - Sair
                | 1 - Tarefa (assuntos gerais)
                | 2 - Tarefa pessoal
                | 3 - Tarefa de estudos
                | 4 - Tarefa de trabalho
                 """;
        System.out.println(subMenu);
        System.out.print("Digite o número do tipo de tarefa escolhida: ");
        String option = scanner.nextLine();
        switch (option) {
            case "0":
                System.out.println("Inclusão de tarefa encerrada pelo usuário.");
                break;
            case "1":
                createTask();
                break;
            case "2":
                createPersonalTask();
                break;
            case "3":
                createStudyTask();
                break;
            case "4":
                createWorkTask();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void createTask() {
        System.out.print("Salvando uma tarefa (geral). Qual o nome/descrição da tarefa?: ");
        String nome = scanner.nextLine();
        System.out.print("Qual o status da tarefa?: ");
        String status = scanner.nextLine();
        System.out.print("Qual a prioridade da tarefa?: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        this.service.salvarNovaTask(new BaseTask(nome, status, id));
    }

    public void createPersonalTask() {
        System.out.print("Salvando uma tarefa pessoal. Qual o nome/descrição da tarefa?: ");
        String nome = scanner.nextLine();
        System.out.print("Qual o tipo da tarefa? Casa, Saúde, Lazer, etc: ");
        String tipo = scanner.nextLine();
        System.out.print("Qual o status da tarefa?: ");
        String status = scanner.nextLine();
        System.out.print("Qual a prioridade da tarefa?: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        this.service.salvarNovaTask(new PersonalTask(nome, status, id, tipo));
    }

    public void createStudyTask() {
        System.out.print("Salvando uma tarefa de estudos. Qual o nome/descrição da tarefa?: ");
        String nome = scanner.nextLine();
        System.out.print("Qual disciplina/assunto é relacionada da tarefa?: ");
        String disciplina = scanner.nextLine();
        System.out.print("Qual o status da tarefa?: ");
        String status = scanner.nextLine();
        System.out.print("Qual a prioridade da tarefa?: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        this.service.salvarNovaTask(new StudyTask(nome, status, id, disciplina));
    }

    public void createWorkTask() {
        System.out.print("Salvando uma tarefa de trabalho. Qual o nome/descrição da tarefa?: ");
        String nome = scanner.nextLine();
        System.out.print("Qual projeto é relacionado da tarefa?: ");
        String projeto = scanner.nextLine();
        System.out.print("Qual o status da tarefa?: ");
        String status = scanner.nextLine();
        System.out.print("Qual a prioridade da tarefa?: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        this.service.salvarNovaTask(new WorkTask(nome, status, id, projeto));
    }

    private void listTasks() {
        System.out.println("Listar todas as tarefas:");
        List<BaseTask> list = this.service.listTasks();
        if (list.isEmpty()) System.out.println("Lista vazia.");
        else {
            for (BaseTask task : list) {
                System.out.println(task);
            }
        }
    }

    private void listOneTask() {
        System.out.println("Mostrar uma tarefa específica.");
        System.out.print("Qual tarefa você ver? Mencione o id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        BaseTask task = this.service.listOneTask(id);
        if (task == null) {
            System.out.println("Tarefa não encontrada.");
        } else {
            System.out.println("Tarefa solicitada: " + task);
        }
    }

    private void updateTask() {
        System.out.println("Atualizar uma tarefa.");
        System.out.print("Qual tarefa você ver? Mencione o id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        BaseTask task = this.service.listOneTask(id);
        if (task != null) {
            System.out.println("A seguinte task foi encontrada:");
            System.out.println(task);
            switch (task) {
                case PersonalTask personalTask1 ->
                        System.out.print("O que você quer atualizar? Digite 1 para nome, 2 para status, " +
                                "3 para prioridade, 4 para tipo: ");
                case StudyTask studyTask ->
                        System.out.print("O que você quer atualizar? Digite 1 para nome, 2 para status, " +
                                "3 para prioridade, 4 para assunto: ");
                case WorkTask workTask ->
                        System.out.print("O que você quer atualizar? Digite 1 para nome, 2 para status, " +
                                "3 para prioridade, 4 para projeto: ");
                default -> System.out.print("O que você quer atualizar? Digite 1 para nome, 2 para status, " +
                        "3 para prioridade: ");
            }
            int updateOption = Integer.parseInt(scanner.nextLine());
            switch (updateOption) {
                case 1:
                    System.out.print("Digite o novo nome/descrição: ");
                    String novoNome = scanner.nextLine();
                    task.setNome(novoNome);
                    this.service.updateTask(id, task);
                    System.out.println("Nome da tarefa atualizada com sucesso.");
                    System.out.println(task);
                    break;
                case 2:
                    System.out.print("Digite o novo status: ");
                    String novoStatus = scanner.nextLine();
                    task.setStatus(novoStatus);
                    this.service.updateTask(id, task);
                    System.out.println("Status da tarefa atualizada com sucesso.");
                    System.out.println(task);
                    break;
                case 3:
                    System.out.print("Digite a nova prioridade da tarefa: ");
                    int novaPrioridade = Integer.parseInt(scanner.nextLine());
                    task.setPrioridade(novaPrioridade);
                    this.service.updateTask(id, task);
                    System.out.println("Prioridade da tarefa atualizada com sucesso.");
                    System.out.println(task);
                    break;
                case 4:
                    switch (task) {
                        case PersonalTask personalTask:
                            System.out.print("Digite o novo tipo da tarefa: ");
                            String novoTipo = scanner.nextLine();
                            personalTask.setTipo(novoTipo);
                            this.service.updateTask(id, personalTask);
                            System.out.println("Tipo da tarefa atualizado com sucesso.");
                            System.out.println(personalTask);
                            break;
                        case StudyTask studyTask:
                            System.out.print("Digite o novo assunto da tarefa: ");
                            String novoAssunto = scanner.nextLine();
                            studyTask.setAssunto(novoAssunto);
                            this.service.updateTask(id, studyTask);
                            System.out.println("Assunto da tarefa atualizado com sucesso.");
                            System.out.println(studyTask);
                            break;
                        case WorkTask workTask:
                            System.out.print("Digite o novo projeto da tarefa: ");
                            String novoProjeto = scanner.nextLine();
                            workTask.setProjeto(novoProjeto);
                            this.service.updateTask(id, workTask);
                            System.out.println("Projeto da tarefa atualizado com sucesso.");
                            System.out.println(workTask);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }

        } else {
            System.out.println("Não há tarefa com este id informado.");
        }
    }

    private void deleteTask() {
        System.out.println("Deletar uma tarefa.");
        System.out.print("Qual tarefa você quer deletar? Mencione o id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        BaseTask task = this.service.listOneTask(id);
        if (task != null) {
            System.out.println("A seguinte task foi encontrada:");
            System.out.println(task);
            System.out.print("Você tem certeza que quer deletar? Digite s para sim, n para não: ");
            String deleteOption = scanner.nextLine();
            switch (deleteOption) {
                case "s":
                    this.service.deleteTask(id);
                    System.out.println("Tarefa deletada com sucesso.");
                    break;
                case "n":
                    System.out.println("Função deletar cancelada.");
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        } else {
            System.out.println("Não há tarefa com este id informado.");
        }
    }
}