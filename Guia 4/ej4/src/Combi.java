public class Combi extends Vehiculo{
    private int plazas;
    private double multiplicador = 0.02;

    public Combi(String patente, int plazas) {
        super(patente);
        this.plazas = plazas;
    }

    public double getPrecio(int cantDias){
        return (this.getPrecioBase() * (1 + this.plazas*this.multiplicador) * cantDias);
    }
}
