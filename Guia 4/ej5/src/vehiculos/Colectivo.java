package vehiculos;

public class Colectivo extends Vehiculo{
    private int cantidadPasajeros;

    public Colectivo(String patente, String modelo, int cantidadPasajeros) {
        super(patente, modelo);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
}
