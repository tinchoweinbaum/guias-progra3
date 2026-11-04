public class Camion extends Vehiculo{
    private double multiplicador = 0.4;

    public Camion(String patente) {
        super(patente);
    }

    public double getPrecio(int cantDias){
        return this.getPrecioBase() * (1 + this.multiplicador) * cantDias;
    }
}
