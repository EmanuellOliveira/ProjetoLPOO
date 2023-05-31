public class DespesaVariada extends Despesas{
    int classificacao;

    public DespesaVariada(String nome, String descricao, double valor, int classificacao) {
        super(nome, descricao, valor);
        this.classificacao = classificacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public double getValorVariada() {
        return super.getValor();
    }
}
