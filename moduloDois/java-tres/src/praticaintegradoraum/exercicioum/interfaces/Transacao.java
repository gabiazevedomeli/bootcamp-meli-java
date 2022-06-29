package praticaintegradoraum.exercicioum.interfaces;

public interface Transacao {
    public void transacaoOk(String tipoTransacao);
    public void transacaoNaoOk(String tipoTransacao);
}
