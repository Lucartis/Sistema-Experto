import java.util.ArrayList;

public class Predicado {
    private boolean negado;
    private String nombre;
    //private ArrayList<String> variables = new ArrayList<String>();


    public Predicado() {
    }

    public Predicado(Boolean negado, String nombre, ArrayList<String> variables) {
        this.negado = negado;
        this.nombre = nombre;
        //this.variables = variables;
    }

    public Boolean getNegado() {
        return negado;
    }

    public void setNegado(Boolean negado) {
        this.negado = negado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Predicado other = (Predicado) obj;
        return negado == other.negado && nombre.equals(other.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(negado, nombre);
    }

    @Override
    public String toString() {
        if(negado){
            return "-" + nombre;
        }
        return nombre;
    }
}
