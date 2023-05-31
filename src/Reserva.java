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
    public double getValor() {
        return valor;
    }
}
