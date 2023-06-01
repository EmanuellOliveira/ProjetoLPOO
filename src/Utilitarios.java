import java.util.*;

public class Utilitarios {

    private static final List<Aluno> listAluno = new ArrayList<>();
    private static final List<DespesaFixa> listDespesaFixa = new ArrayList<>();
    private static final List<DespesaVariada> listDespesaVariada = new ArrayList<>();
    private static final List<Reserva> listReserva = new ArrayList<>();

    // MENUS
    public static void menuApp() {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nAPLICATIVO DE DIVISÃO DE DESPESAS");
            System.out.println("******************************");
            System.out.println("1- Cadastrar aluno");
            System.out.println("2- Cadastrar despesa");
            System.out.println("3- Calcular divisão");
            System.out.println("4- Relatórios");
            System.out.println("0 - Sair");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuTipoDespesas();
                    break;
                case 3:
                    dividirDespesasIgualmente();
                    break;
                case 4:
                    menuRelatorios();
                    ;
                    break;
                case 0:
                    System.out.println("Programa encerrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    } // OK

    public static void menuAluno() {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\nCADASTRO DE ALUNOS");
            System.out.println("******************************");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Adicionar Reserva");
            System.out.println("0 - Voltar");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    editarAluno();
                    break;
                case 3:
                    excluirAluno();
                    break;
                case 4:
                    adicionarReserva();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    } // OK

    public static void menuRelatorios() {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\nRELATÓRIOS");
            System.out.println("******************************");
            System.out.println("1 - Gerar relatório de Alunos");
            System.out.println("2 - Gerar relatório de Alunos Inadimplentes");
            System.out.println("3 - Gerar relatório de Reservas");
            System.out.println("4 - Gerar relatório de Despesas");
            System.out.println("0 - Voltar");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    gerarRelatorioAluno();
                    break;
                case 2:
                    gerarRelatorioAlunoInadimplente();
                    break;
                case 3:
                    gerarRelatorioReserva();
                    break;
                case 4:
                    gerarRelatorioDespesas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void menuDespesaFixa() {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\nCADASTRO DE DESPESAS FIXAS");
            System.out.println("******************************");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("0 - Voltar");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    adicionarDespesasFixas();
                    break;
                case 2:
                    editarDespesasFixas();
                    break;
                case 3:
                    excluirDespesasFixas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    } // OK

    public static void menuDespesaVariada() {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\nCADASTRO DE DESPESAS VARIADAS");
            System.out.println("******************************");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("0 - Voltar");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    adicionarDespesasVariadas();
                    break;
                case 2:
                    editarDespesasVariadas();
                    break;
                case 3:
                    excluirDespesasVariadas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

    }

    public static void menuTipoDespesas() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("\nQual tipo de despesas deseja adicionar?");
            System.out.println("******************************");
            System.out.println("1 - Despesa Fixa");
            System.out.println("2 - Despesa Variada");
            System.out.println("0 - Voltar");
            System.out.println("******************************");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    menuDespesaFixa();
                    break;
                case 2:
                    menuDespesaVariada();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

    }

    // ALUNOS

    public static void gerarRelatorioAluno() {
        String nomeDoArquivo = "alunos.txt";
        Relatorios.gerarRelatorioAluno(listAluno, nomeDoArquivo);
    } // OK

    public static void adicionarAluno() {
        Scanner entrada = new Scanner(System.in);
        boolean adicionarMaisAlunos = true;
        do {
            System.out.println("Digite o nome do aluno: ");
            String nome = entrada.nextLine();

            System.out.println("Digite o email do aluno: ");
            String email = entrada.nextLine();

            double rendimento;
            while (true) {
                try {
                    System.out.println("Digite o rendimento do aluno: ");
                    rendimento = entrada.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                    entrada.nextLine();

                }
            }

            Aluno aluno = new Aluno(nome, email, rendimento);
            listAluno.add(aluno);

            System.out.println("\n| Aluno cadastrado com sucesso! |");
            System.out.println("\nDeseja adicionar mais alunos?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int resposta = entrada.nextInt();
            entrada.nextLine();

            if (resposta == 2) {
                adicionarMaisAlunos = false;
            }
        } while (adicionarMaisAlunos);
    } // OK

    public static void editarAluno() {
        if (listAluno.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
        } else {
            System.out.println("Lista de Alunos cadastrados: ");
            for (int i = 0; i < listAluno.size(); i++) {
                Aluno aluno = listAluno.get(i);
                System.out.println((i + 1) + "." + aluno.getNome());
            }

            while (true) {
                try {
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Digite o número do aluno que deseja editar: ");
                    int numeroAluno = entrada.nextInt();

                    if (numeroAluno > 0 && numeroAluno <= listAluno.size()) {

                        Aluno alunoSelecionado = listAluno.get(numeroAluno - 1);
                        System.out.println("Aluno selecionado: " + alunoSelecionado.getNome());
                        entrada.nextLine();

                        System.out.println("Digite o novo nome: ");
                        String nome = entrada.nextLine();
                        alunoSelecionado.setNome(nome);

                        System.out.println("Digite o novo email: ");
                        String email = entrada.nextLine();
                        alunoSelecionado.setEmail(email);

                        while (true) {
                            try {
                                System.out.println("Digite o novo rendimento: ");
                                double rendimento = entrada.nextDouble();
                                alunoSelecionado.setRendimento(rendimento);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido! Por favor, inserir novamente.");
                            }
                        }
                        System.out.println("\nAluno editado com sucesso!");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                }
            }
        }
    } // OK

    public static void excluirAluno() {
        if (listAluno.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
        } else {
            System.out.println("Lista de Alunos cadastrados: ");
            for (int i = 0; i < listAluno.size(); i++) {
                Aluno aluno = listAluno.get(i);
                System.out.println((i + 1) + "." + aluno.getNome());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o número do aluno que deseja excluir: ");
            int numeroAluno = entrada.nextInt();

            if (numeroAluno > 0 && numeroAluno <= listDespesaFixa.size()) {
                listDespesaFixa.remove(numeroAluno - 1);
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    } // OK

    // DESPESAS

    public static void gerarRelatorioDespesas() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o mês: ");
        String mes = entrada.nextLine();
        System.out.println("Insira o ano: ");
        String ano = entrada.nextLine();

        String nomeDoArquivo = "despesas_" + mes + "_" + ano + ".txt";
        Relatorios.gerarRelatorioDespesas(listDespesaFixa, listDespesaVariada, nomeDoArquivo);
    } // OK

    public static void adicionarDespesasFixas() {
        System.out.println("\n-----DESPESAS FIXAS-----");
        Scanner entrada = new Scanner(System.in);
        boolean adicionarMaisDespesas = true;
        do {
            System.out.println("Digite o nome da despesa: ");
            String nome = entrada.nextLine();

            System.out.println("Digite a descricao da despesa: ");
            String descricao = entrada.nextLine();

            System.out.println("Digite a data da despesa: ");
            String data = entrada.nextLine();

            double valor;
            while (true) {
                try {
                    System.out.println("Digite o valor da despesa: ");
                    valor = entrada.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                    entrada.nextLine();
                }
            }

            DespesaFixa despesaFixa = new DespesaFixa(nome, descricao, valor, data);
            listDespesaFixa.add(despesaFixa);

            System.out.println("\n| Despesa Fixa cadastrada com sucesso! |");
            System.out.println("\nDeseja adicionar mais dessas despesas?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int resposta = entrada.nextInt();
            entrada.nextLine();

            if (resposta == 2) {
                adicionarMaisDespesas = false;
            }
        } while (adicionarMaisDespesas);
    } // OK

    public static void editarDespesasFixas() {
        System.out.println("\n-----DESPESAS FIXAS-----");
        if (listDespesaFixa.isEmpty()) {
            System.out.println("Não há despesas cadastrados!");
        } else {
            System.out.println("Lista de Despesas cadastradas: ");
            for (int i = 0; i < listDespesaFixa.size(); i++) {
                DespesaFixa despesaFixa = listDespesaFixa.get(i);
                System.out.println((i + 1) + "." + despesaFixa.getNome());
            }

            while (true) {
                try {
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Digite o número da Despesa que deseja editar: ");
                    int numeroDespesa = entrada.nextInt();

                    if (numeroDespesa > 0 && numeroDespesa <= listDespesaFixa.size()) {

                        DespesaFixa despesaFixaSelecionada = listDespesaFixa.get(numeroDespesa - 1);
                        System.out.println("Despesa selecionada: " + despesaFixaSelecionada.getNome());
                        entrada.nextLine();

                        System.out.println("Digite o novo nome da Despesa: ");
                        String nome = entrada.nextLine();
                        despesaFixaSelecionada.setNome(nome);

                        System.out.println("Digite a nova descrição: ");
                        String descricao = entrada.nextLine();
                        despesaFixaSelecionada.setDescricao(descricao);

                        while (true) {
                            try {
                                System.out.println("Digite o novo valor: ");
                                double valor = entrada.nextDouble();
                                despesaFixaSelecionada.setValor(valor);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido! Por favor, inserir novamente.");
                            }
                        }
                        System.out.println("Digite a nova data: ");
                        String data = entrada.nextLine();
                        despesaFixaSelecionada.setData(data);
                        entrada.nextLine();

                        System.out.println("\nDespesa Fixa editada com sucesso!");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                }
            }
        }
    } // OK

    public static void excluirDespesasFixas() {
        System.out.println("\n-----DESPESAS FIXAS-----");
        if (listDespesaFixa.isEmpty()) {
            System.out.println("Não há Despesas Fixas cadastradas!");
        } else {
            System.out.println("Lista de Despesas Fixas cadastradas: ");
            for (int i = 0; i < listDespesaFixa.size(); i++) {
                DespesaFixa despesaFixa = listDespesaFixa.get(i);
                System.out.println((i + 1) + "." + despesaFixa.getNome());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o número da Despesa que deseja excluir: ");
            int numeroDespesa = entrada.nextInt();

            if (numeroDespesa > 0 && numeroDespesa <= listDespesaFixa.size()) {
                listDespesaFixa.remove(numeroDespesa - 1);
                System.out.println("Despesa Fixa excluída com sucesso!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    } // OK

    public static void adicionarDespesasVariadas() {
        System.out.println("\n-----DESPESAS VARIADAS-----");
        Scanner entrada = new Scanner(System.in);
        boolean adicionarMaisDespesas = true;
        do {
            System.out.println("Digite o nome da despesa: ");
            String nome = entrada.nextLine();

            System.out.println("Digite a descricao da despesa: ");
            String descricao = entrada.nextLine();

            System.out.println("Digite a classificação da despesa: ");
            int classificacao = entrada.nextInt();

            double valor;
            while (true) {
                try {
                    System.out.println("Digite o valor da despesa: ");
                    valor = entrada.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                    entrada.nextLine();
                }
            }

            DespesaVariada despesaVariada = new DespesaVariada(nome, descricao, valor, classificacao);
            listDespesaVariada.add(despesaVariada);

            System.out.println("\n| Despesa Variada cadastrada com sucesso! |");
            System.out.println("\nDeseja adicionar mais dessas despesas?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int resposta = entrada.nextInt();
            entrada.nextLine();

            if (resposta == 2) {
                adicionarMaisDespesas = false;
            }
        } while (adicionarMaisDespesas);
    } // OK

    public static void editarDespesasVariadas() {
        System.out.println("\n-----DESPESAS VARIADAS-----");
        if (listDespesaVariada.isEmpty()) {
            System.out.println("Não há despesas cadastrados!");
        } else {
            System.out.println("Lista de Despesas cadastradas: ");
            for (int i = 0; i < listDespesaVariada.size(); i++) {
                DespesaVariada despesaVariada = listDespesaVariada.get(i);
                System.out.println((i + 1) + "." + despesaVariada.getNome());
            }

            while (true) {
                try {
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Digite o número da Despesa que deseja editar: ");
                    int numeroDespesa = entrada.nextInt();

                    if (numeroDespesa > 0 && numeroDespesa <= listDespesaVariada.size()) {

                        DespesaVariada despesaVariadaSelecionada = listDespesaVariada.get(numeroDespesa - 1);
                        System.out.println("Despesa selecionada: " + despesaVariadaSelecionada.getNome());
                        entrada.nextLine();

                        System.out.println("Digite o novo nome da Despesa: ");
                        String nome = entrada.nextLine();
                        despesaVariadaSelecionada.setNome(nome);

                        System.out.println("Digite a nova descrição: ");
                        String descricao = entrada.nextLine();
                        despesaVariadaSelecionada.setDescricao(descricao);

                        while (true) {
                            try {
                                System.out.println("Digite o novo valor: ");
                                double valor = entrada.nextDouble();
                                despesaVariadaSelecionada.setValor(valor);
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Valor inválido! Por favor, inserir novamente.");
                            }
                        }
                        System.out.println("Digite a nova classificação: ");
                        int classificacao = entrada.nextInt();
                        despesaVariadaSelecionada.setClassificacao(classificacao);

                        System.out.println("\nDespesa Variada editada com sucesso!");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido! Por favor, inserir novamente.");
                }
            }
        }
    } // OK

    public static void excluirDespesasVariadas() {
        System.out.println("\n-----DESPESAS VARIADAS-----");
        if (listDespesaVariada.isEmpty()) {
            System.out.println("Não há Despesas Variadas cadastradas!");
        } else {
            System.out.println("Lista de Despesas Variadas cadastradas: ");
            for (int i = 0; i < listDespesaVariada.size(); i++) {
                DespesaVariada despesaVariada = listDespesaVariada.get(i);
                System.out.println((i + 1) + "." + despesaVariada.getNome());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o número da Despesa que deseja excluir: ");
            int numeroDespesa = entrada.nextInt();

            if (numeroDespesa > 0 && numeroDespesa <= listDespesaVariada.size()) {
                listDespesaVariada.remove(numeroDespesa - 1);
                System.out.println("Despesa Variada excluída com sucesso!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    } // OK

    public static void adicionarReserva() {
        Scanner entrada = new Scanner(System.in);
        boolean adicionarMaisReservas = true;

        if (listAluno.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
        } else {
            System.out.println("Lista de Alunos cadastrados: ");
            for (int i = 0; i < listAluno.size(); i++) {
                Aluno aluno = listAluno.get(i);
                System.out.println((i + 1) + "." + aluno.getNome());
            }
            do {
                System.out.println("\nDigite o número do aluno para adicionar a reserva: ");
                int numeroAluno = entrada.nextInt();
                entrada.nextLine();

                if (numeroAluno > 0 && numeroAluno <= listAluno.size()) {
                    Aluno alunoSelecionado = listAluno.get(numeroAluno - 1);

                    double rendimento = alunoSelecionado.getRendimento();
                    double valorReserva = rendimento * 0.05;

                    Reserva reserva = new Reserva(alunoSelecionado, valorReserva);
                    listReserva.add(reserva);

                    System.out.println("Reserva cadastrada com sucesso para o aluno: " + alunoSelecionado.getNome());
                    System.out.println("Valor retirado do aluno: " + valorReserva);
                } else {
                    System.out.println("Opção inválida!");
                }

                System.out.println("\nDeseja adicionar mais reservas?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");

                int resposta = entrada.nextInt();
                entrada.nextLine();

                if (resposta == 2) {
                    adicionarMaisReservas = false;
                }
            } while (adicionarMaisReservas);
        }
    }

    public static void gerarRelatorioReserva() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o mês: ");
        String mes = entrada.nextLine();
        System.out.println("Insira o ano: ");
        String ano = entrada.nextLine();

        String nomeDoArquivo = "reservas_" + mes + "_" + ano + ".txt";
        Relatorios.gerarRelatorioReserva(listReserva, nomeDoArquivo);
    }

    public static void gerarRelatorioAlunoInadimplente() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o mês: ");
        String mes = entrada.nextLine();
        System.out.println("Insira o ano: ");
        String ano = entrada.nextLine();

        String nomeDoArquivo = "alunos_Inadimplentes_" + mes + "_" + ano + ".txt";
        Relatorios.gerarRelatorioAlunoInadimplente(listAluno, listReserva, nomeDoArquivo);
    }

    public static void dividirDespesasIgualmente() {
        if (listAluno.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
            return;
        }

        for (Aluno aluno : listAluno) {
            System.out.println("\nAluno: " + aluno.getNome());
            double valorContribuicao = calcularValorContribuicao();
            System.out.println(
                    "Valor da contribuição mensal para o aluno " + aluno.getNome() + ": " + valorContribuicao + "R$");
        }
    }

    private static double calcularTotalDespesasFixas() {
        double totalDespesasFixas = 0;
        for (DespesaFixa despesaFixa : listDespesaFixa) {
            totalDespesasFixas += despesaFixa.getValorFixa();
        }
        return totalDespesasFixas;
    }

    private static double calcularTotalDespesasVariadas() {
        double totalDespesasVariadas = 0;
        for (DespesaVariada despesaVariada : listDespesaVariada) {
            if (despesaVariada.getClassificacao() == 4 || despesaVariada.getClassificacao() == 5) {
                totalDespesasVariadas += despesaVariada.getValorVariada();
            }
        }
        return totalDespesasVariadas;
    }

    static List<DespesaVariada> obterDespesasNaoIncluidas() {
        List<DespesaVariada> despesasNaoIncluidas = new ArrayList<>();
        for (DespesaVariada despesaVariada : listDespesaVariada) {
            if (despesaVariada.getClassificacao() == 1 || despesaVariada.getClassificacao() == 2 ||
                    despesaVariada.getClassificacao() == 3) {
                despesasNaoIncluidas.add(despesaVariada);
            }
        }
        return despesasNaoIncluidas;
    }

    private static double calcularValorContribuicao() {
        double despesas = 0.0;
        int quantidadeAlunos = listAluno.size();
        despesas = calcularTotalDespesasFixas() + calcularTotalDespesasVariadas();
        double valorContribuicao = (despesas / quantidadeAlunos);

        return valorContribuicao;
    }
}
