import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Relatorios {

    public static void gerarRelatorioAluno(List<Aluno> listAlunos, String alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(alunos))) {
            writer.write("Relatório de Alunos");
            writer.newLine();
            writer.write("--------------------------------");
            writer.newLine();
            writer.newLine();

            for (Aluno aluno : listAlunos) {
                writer.write("Nome: " + aluno.getNome());
                writer.newLine();
                writer.write("Email: " + aluno.getEmail());
                writer.newLine();
                writer.write("Total de Rendimento: " + aluno.getRendimento() + "R$");
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nRelatório gerado com sucesso!");

    }

    public static void gerarRelatorioDespesas(List<DespesaFixa> listDespesasFixas,
                                              List<DespesaVariada> listDespesasVariadas, String despesas) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(despesas))) {
            writer.write("Relatório de Despesas");
            writer.newLine();
            writer.write("--------------------------------");
            writer.newLine();
            writer.newLine();

            for (DespesaFixa despesaFixa : listDespesasFixas) {
                writer.write("Nome: " + despesaFixa.getNome());
                writer.newLine();
                writer.write("Descrição: " + despesaFixa.getDescricao());
                writer.newLine();
                writer.write("Valor: " + despesaFixa.getValor() + "R$");
                writer.newLine();
                writer.write("Categoria: Despesa Fixa");
                writer.newLine();
                writer.write("Data de Pagamento: " + despesaFixa.getData());
                writer.newLine();
                writer.newLine();
            }

            for (DespesaVariada despesaVariada : listDespesasVariadas) {
                writer.write("Nome: " + despesaVariada.getNome());
                writer.newLine();
                writer.write("Descrição: " + despesaVariada.getDescricao());
                writer.newLine();
                writer.write("Valor: " + despesaVariada.getValor() + "R$");
                writer.newLine();
                writer.write("Categoria: Despesa Variada");
                writer.newLine();
                writer.write("Classificação: " + despesaVariada.getClassificacao());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nRelatório gerado com sucesso!");
    }

    public static void gerarRelatorioReserva(List<Reserva> listReservas, String reservas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservas))) {
            writer.write("Relatório de Reservas");
            writer.newLine();
            writer.write("--------------------------------");
            writer.newLine();
            writer.newLine();

            for (Reserva reserva : listReservas) {
                writer.write("Nome: " + reserva.getAluno().getNome());
                writer.newLine();
                writer.write("Rendimento " + reserva.getAluno().getRendimento() + "R$");
                writer.newLine();
                writer.write("Valor da reserva: " + reserva.getValor() + "R$");
                writer.newLine();
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nRelatório gerado com sucesso!");
    }

    public static void gerarRelatorioAlunoInadimplente(@org.jetbrains.annotations.NotNull List<Aluno> alunosInadimplentes, List<Reserva> reservas,
                                                       String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Relatório de Alunos Inadimplentes com a Reserva");
            writer.newLine();
            writer.write("--------------------------------");
            writer.newLine();
            writer.newLine();

            if (alunosInadimplentes.isEmpty()) {
                writer.write("Não há alunos inadimplentes!");
            } else {
                writer.write("Lista de Alunos Inadimplentes sem Reserva: ");
                writer.newLine();

                for (Aluno aluno : alunosInadimplentes) {
                    boolean estaNaReserva = false;

                    for (Reserva reserva : reservas) {
                        if (aluno.getNome().equals(reserva.getAluno().getNome())) {
                            estaNaReserva = true;
                            break;
                        }
                    }

                    if (!estaNaReserva) {
                        writer.write("Nome: " + aluno.getNome());
                        writer.newLine();
                        writer.newLine();
                    }
                }
            }

            writer.newLine();
            writer.write("Despesas não incluídas no cálculo: ");
            writer.newLine();

            List<DespesaVariada> despesasNaoIncluidas = Utilitarios.obterDespesasNaoIncluidas();
            if (despesasNaoIncluidas.isEmpty()) {
                writer.write("Todas as despesas foram incluídas no cálculo.");
            } else {
                for (DespesaVariada despesaVariada : despesasNaoIncluidas) {
                    writer.write("Nome: " + despesaVariada.getNome() + ", Valor: " + despesaVariada.getValorVariada());
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.write("OS ALUNOS LISTADOS NESSE RELATÓRIO TERÃO QUE PAGAR AS DEVIDAS DESPESAS TAMBÉM LISTADAS.");
            writer.newLine();
            writer.newLine();

            System.out.println("\nRelatório gerado com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}