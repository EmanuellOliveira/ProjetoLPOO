package despesas;

public class DespesaVariada extends Despesas{
    private int classificacao;

    public DespesaVariada(String nome, String descricao, double valor) {
        super(nome, descricao, valor);
    }

    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
