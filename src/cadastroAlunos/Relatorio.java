package cadastroAlunos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Relatorio {

    public static void gerarRelatorio(List<Aluno> listAlunos, String alunos){
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
}
