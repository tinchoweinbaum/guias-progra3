import java.io.Serializable;
import java.util.ArrayList;

public class Flota implements Serializable {
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Flota() {
    }

    public Flota(String nombre, ArrayList<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.vehiculos = vehiculos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Flota{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
