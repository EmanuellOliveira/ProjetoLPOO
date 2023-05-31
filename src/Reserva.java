public class Reserva {
    private Aluno aluno;
    private double valor;

    public Reserva(Aluno aluno, double valor) {
        this.aluno = aluno;
        this.valor = valor;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
