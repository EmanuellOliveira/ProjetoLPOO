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

    @Override
    public String toString() {
        return "Aluno" +
                "Nome: " + nome + '\'' +
                "Email: " + email + '\'' +
                "Rendimento: " + rendimento;
    }
}

