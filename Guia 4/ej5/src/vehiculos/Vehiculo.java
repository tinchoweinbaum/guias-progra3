package vehiculos;

public abstract class Vehiculo {
    private final String patente;
    private final String modelo;

    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    // abstract boolean aceptaChofer(Chofer c);
}
