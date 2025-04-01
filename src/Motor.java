import java.util.ArrayList;

import java.util.ArrayList;

public class Motor {
    private ArrayList<Regla> reglas = new ArrayList<>();
    private ArrayList<Predicado> hechos = new ArrayList<>();

    public void agregarHecho(Predicado hecho) {
        if(!hechos.contains(hecho)) {
            hechos.add(hecho);
        }
    }

    public void add_regla(Regla regla){
        reglas.add(regla);
    }

    public void encadenamientoHaciaAdelante() {
        System.out.println("Iniciando encadenamiento hacia adelante...");
        boolean cambio = true;
        while(cambio) {
            cambio = false;
            System.out.println("Iniciando nuevo ciclo de evaluación de reglas...");
            for(Regla regla : reglas) {
                System.out.println("Evaluando regla: " + regla);
                if (regla.getIfPredicados().isEmpty()) {
                    System.out.println("La regla no tiene predicados en el IF. Se omite.");
                    continue;
                }
                boolean cumple;
                if(regla.isIfEsAnd()) {
                    System.out.println("Tipo de regla: AND");
                            cumple = true;
                    for(Predicado p : regla.getIfPredicados()) {
                        System.out.println("Predicado: " + p + " vs. Hechos: " + hechos);
                        if(!hechos.contains(p)) {
                            cumple = false;
                            System.out.println("No se encontró el predicado: " + p);
                            break;
                        }
                    }
                } else {
                    System.out.println("Tipo de regla: OR");
                            cumple = false;
                    for(Predicado p : regla.getIfPredicados()) {
                        if(hechos.contains(p)) {
                            cumple = true;
                            System.out.println("Se encontró el predicado: " + p);
                            break;
                        }
                    }
                }
                // Se evalua el predicado de la parte THEN
                if(cumple && !hechos.contains(regla.getThenPredicado())) {
                    System.out.println(" -> Se agrega hecho: " + regla.getThenPredicado());
                            agregarHecho(regla.getThenPredicado());
                    cambio = true;
                }
            }
        }
        System.out.println("Encadenamiento finalizado.");
    }

    public ArrayList<Predicado> getHechos() {
        return hechos;
    }
}