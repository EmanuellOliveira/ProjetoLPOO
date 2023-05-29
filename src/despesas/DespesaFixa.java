package despesas;

public class DespesaFixa extends Despesas{
    private String data;

    public DespesaFixa(String nome, String descricao, double valor) {
        super(nome, descricao, valor);
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
