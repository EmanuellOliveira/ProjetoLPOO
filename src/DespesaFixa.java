public class DespesaFixa extends Despesas{
    private String data;

    public DespesaFixa(String nome, String descricao, double valor, String data) {
        super(nome, descricao, valor);
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
