public class Carga extends Vehiculo{
    private double multiplicador = 0.2;
    private double pma;

    /**
     *
     * @param patente -> Patente del Mercosur formato XX999XX
     * @param pma -> Numero real: peso maximo en toneladas
     */
    public Carga(String patente, double pma) {
        super(patente);
        this.pma = pma;
    }

    @Override
    public double getPrecio(int diasAlq) {
        return diasAlq * (this.getPrecioBase() * (1 + this.multiplicador * pma));
    }
}
