package choferes;

import vehiculos.Vehiculo;

public class Chofer {
    String nombre;
    Categoria categoria;
    vehiculos.Vehiculo vehiculoAsignado;

    public Chofer(String nombre, Categoria categoria, Vehiculo vehiculoAsignado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void setVehiculoAsignado(Vehiculo vehiculoAsignado) {
        this.vehiculoAsignado = vehiculoAsignado;
    }
}
