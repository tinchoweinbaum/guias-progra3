public abstract class Vehiculo {
    private final String patente;
    private double precioBase = 500;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioAlquiler(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double getPrecio(int diasAlq);
}
