import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de reglas: ");
        int cantidadReglas = scanner.nextInt();
        scanner.nextLine(); // Limpiar salto

        for (int i = 0; i < cantidadReglas; i++) {
            System.out.print("Ingrese la regla " + (i + 1) + " (Ej: IF a AND -b THEN c): ");
            String reglaStr = scanner.nextLine();

            // Separar la parte IF de la parte THEN
            reglaStr = reglaStr.replace("IF ", "");
            String[] partes = reglaStr.split(" THEN ");
            String condicion = partes[0];
            String conclusion = partes[1];

            // Determinar si es AND o OR
            boolean esAnd = condicion.contains(" AND ");
            String[] predicadosCond = esAnd
                    ? condicion.split(" AND ")
                    : condicion.split(" OR ");

            // Crear la regla
            Regla regla = new Regla();
            regla.setIfEsAnd(esAnd);

            // Agregar predicados de la condicion
            for (String token : predicadosCond) {
                Predicado p = new Predicado();
                p.setNegado(token.trim().startsWith("-"));
                p.setNombre(token.replace("-", "").trim());
                regla.getIfPredicados().add(p);
            }

            // Agregar el predicado conclusion
            Predicado thenPred = new Predicado();
            thenPred.setNegado(conclusion.trim().startsWith("-"));
            thenPred.setNombre(conclusion.replace("-", "").trim());
            regla.setThenPredicado(thenPred);

            motor.add_regla(regla);
        }

        System.out.print("¿Cuántos hechos iniciales desea ingresar?: ");
        int cantHechos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantHechos; i++) {
            System.out.print("Ingrese el hecho " + (i + 1) + ": ");
            String hechoStr = scanner.nextLine();
            Predicado hecho = new Predicado();
            hecho.setNegado(hechoStr.trim().startsWith("-"));
            hecho.setNombre(hechoStr.replace("-", "").trim());
            motor.agregarHecho(hecho);
        }

        // Se aplica encadenamiento
        motor.encadenamientoHaciaAdelante();

        System.out.println("Hechos resultantes:");
        for (Predicado p : motor.getHechos()) {
            System.out.println(" * " + p);
        }
    }
}