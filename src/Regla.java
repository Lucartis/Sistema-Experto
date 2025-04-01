import java.util.ArrayList;

public class Regla {

    private ArrayList<Predicado> ifPredicados;
    private boolean ifEsAnd;         // true para AND, false para OR
    private Predicado thenPredicado;

    public Regla() {
        ifPredicados = new ArrayList<>();
    }

    public Regla(ArrayList<Predicado> ifPredicados, boolean ifEsAnd, Predicado thenPredicado) {
        this.ifPredicados = ifPredicados;
        this.ifEsAnd = ifEsAnd;
        this.thenPredicado = thenPredicado;
    }

    public ArrayList<Predicado> getIfPredicados() {
        return ifPredicados;
    }

    public void setIfPredicados(ArrayList<Predicado> ifPredicados) {
        this.ifPredicados = ifPredicados;
    }

    public boolean isIfEsAnd() {
        return ifEsAnd;
    }

    public void setIfEsAnd(boolean ifEsAnd) {
        this.ifEsAnd = ifEsAnd;
    }

    public Predicado getThenPredicado() {
        return thenPredicado;
    }

    public void setThenPredicado(Predicado thenPredicado) {
        this.thenPredicado = thenPredicado;
    }

    @Override
    public String toString() {
        String conector = ifEsAnd ? " AND " : " OR ";
        StringBuilder sb = new StringBuilder("Regla { IF ");
        for (int i = 0; i < ifPredicados.size(); i++) {
            sb.append(ifPredicados.get(i));
            if (i < ifPredicados.size() - 1) {
                sb.append(conector);
            }
        }
        sb.append(" THEN ").append(thenPredicado).append(" }");
        return sb.toString();
    }
}