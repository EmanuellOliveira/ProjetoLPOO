import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Relatorios {
    public static void gerarRelatorioAluno(List<Aluno> listAlunos, String alunos){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(alunos))) {
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
                writer.write("Total de Rendimento: " + aluno.getRendimento());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nRelatório gerado com sucesso!");

    }

    public static void gerarRelatorioDespesas(List<DespesaFixa> listDespesasFixas, List<DespesaVariada> listDespesasVariadas, String despesas){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(despesas))) {
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
                writer.write("Valor: " + despesaFixa.getValor());
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
                writer.write("Valor: " + despesaVariada.getValor());
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

    public static void gerarRelatorioReserva(){

    }
}
