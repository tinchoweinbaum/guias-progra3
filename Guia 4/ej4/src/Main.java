import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Carga de 10 vehículos de distintas clases
        vehiculos.add(new Auto("AB123CD", 2));
        vehiculos.add(new Auto("AE987FG", 4));
        vehiculos.add(new Combi("AD456HI", 12));
        vehiculos.add(new Combi("AF654JK", 19));
        vehiculos.add(new Carga("AA111AA", 2.5));
        vehiculos.add(new Carga("AB222BB", 5.0));
        vehiculos.add(new Camion("AC333CC"));
        vehiculos.add(new Camion("AD444DD"));
        vehiculos.add(new Camion("AE555EE"));
        vehiculos.add(new Camion("AF666FF"));

        // Días de alquiler para probar
        int diasAlquiler = 7;

        System.out.println("PRECIOS DE ALQUILER POR " + diasAlquiler + " DÍAS:");
        System.out.println("----------------------------------------");

        for (Vehiculo v : vehiculos) {
            System.out.println("Vehículo: " + v.getClass().getSimpleName() +
                    " | Patente: " + v.getPatente() +
                    " | Precio: $" + v.getPrecio(diasAlquiler));
        }
    }
}