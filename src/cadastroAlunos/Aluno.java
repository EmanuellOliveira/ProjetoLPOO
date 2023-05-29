package cadastroAlunos;

public class Aluno {

    private String nome;
    private String email;
    private double rendimento;

    public Aluno(String nome, String email, double rendimento) {
        this.nome = nome;
        this.email = email;
        this.rendimento = rendimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public static void cadastrarAluno(Aluno aluno) {
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Email: " + aluno.getEmail());
        System.out.println("Rendimento: " + aluno.getRendimento());


    }
}
