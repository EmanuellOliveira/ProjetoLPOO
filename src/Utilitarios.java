import cadastroAlunos.Aluno;
import cadastroAlunos.Relatorio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilitarios {

    private static List<Aluno> listAlunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        menuApp();
    }

    public static void menuApp(){
            Scanner entrada = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\tAPLICATIVO DE DIVISÃO DE DESPESAS");
                System.out.println("******************************");
                System.out.println("1- Cadastrar aluno");
                System.out.println("2- Cadastrar despesa");
                System.out.println("3- Calcular divisão");
                System.out.println("0 - Sair");
                System.out.println("******************************");

                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1:
                        menuAluno();
                    case 2:
                        System.out.println("Opçao 2");
                        break;

                    case 3:
                        System.out.println("Opçao 3");
                        break;

                    case 0:
                        System.out.println("Programa encerrado com sucesso!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao != 0);
        }


    public static void menuAluno(){
            int opcao2;
            Scanner entrada = new Scanner(System.in);
            do {
                System.out.println("\tCADASTRO DE ALUNO");
                System.out.println("******************************");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Editar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Gerar relatório");
                System.out.println("0 - Voltar");
                System.out.println("******************************");

                opcao2 = entrada.nextInt();
                entrada.nextLine();

                switch (opcao2) {
                    case 1:
                        boolean adicionarMaisAlunos = true;
                        do {
                            System.out.println("Digite o nome do aluno: ");
                            String nome = entrada.nextLine();

                            System.out.println("Digite o email do aluno: ");
                            String email = entrada.nextLine();

                            double rendimento;
                            while (true){
                                try{
                                    System.out.println("Digite o rendimento do aluno: ");
                                    rendimento = entrada.nextDouble();
                                    break;
                                }catch (InputMismatchException e){
                                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                                    entrada.nextLine();

                                }
                            }

                            Aluno aluno = new Aluno(nome, email, rendimento);
                            listAlunos.add(aluno);

                            System.out.println("\n| Aluno cadastrado com sucesso! |");
                            System.out.println("\nDeseja adicionar mais alunos?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");

                            int resposta = entrada.nextInt();
                            entrada.nextLine();

                            if(resposta == 2){
                                adicionarMaisAlunos = false;
                            }
                        } while (adicionarMaisAlunos);
                        break;

                    case 2:
                        editarAluno();
                        break;
                    case 3:
                        System.out.println("Opçao 3");
                        break;
                    case 4:
                        gerarRelatorio();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao2 != 0);
        }

        public static void gerarRelatorio(){
            String nomeDoArquivo = "alunos.txt";
            Relatorio.gerarRelatorio(listAlunos, nomeDoArquivo);
        }

        public static void editarAluno(){
            if (listAlunos.isEmpty()){
                System.out.println("Não há alunos cadastrados!");
                return;
            }else{
                System.out.println("Lista de Alunos cadastrados: ");
                for (int i = 0; i < listAlunos.size(); i++){
                    Aluno aluno = listAlunos.get(i);
                    System.out.println((i + 1) + "." + aluno.getNome());
                }

                while (true) {
                    try {
                        Scanner entrada = new Scanner(System.in);
                        System.out.println("Digite o número do aluno que deseja editar: ");
                        int numeroAluno = entrada.nextInt();

                        if (numeroAluno > 0 && numeroAluno <= listAlunos.size()) {

                            Aluno alunoSelecionado = listAlunos.get(numeroAluno - 1);
                            System.out.println("Aluno selecionado: " + alunoSelecionado.getNome());
                            entrada.nextLine();

                            System.out.println("Digite o novo nome: ");
                            String nome = entrada.nextLine();
                            alunoSelecionado.setNome(nome);

                            System.out.println("Digite o novo email: ");
                            String email = entrada.nextLine();
                            alunoSelecionado.setEmail(email);

                            while (true){
                                try {
                                    System.out.println("Digite o novo rendimento: ");
                                    double rendimento = entrada.nextDouble();
                                    alunoSelecionado.setRendimento(rendimento);
                                    break;
                                }catch (InputMismatchException e) {
                                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                                }
                                System.out.println("\nAluno editado com sucesso!");
                            }

                        } else {
                            System.out.println("Opção inválida!");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Valor inválido! Por favor, inserir novamente.");
                    }
                    break;
                }
            }
        }
    }
