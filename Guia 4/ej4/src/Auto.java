public class Auto extends Vehiculo{
    private int plazas;
    private final double multiplicador = 0.015;

    /**
     *
     * @param patente -> Patente del Mercosur formato XX999XX
     * @param plazas -> Numero entero positivo
     */
    public Auto(String patente, int plazas){
        super(patente);
        this.plazas = plazas;
    }

    public double getPrecio(int cantDias){
        return (this.getPrecioBase() * (1 + this.plazas*this.multiplicador) * cantDias);
    }
}
