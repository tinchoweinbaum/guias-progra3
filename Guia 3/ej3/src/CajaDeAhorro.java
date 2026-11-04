public class CajaDeAhorro extends CuentaBancaria{
    private int maxExtracMensuales;
    private int cantExtracMensuales;

    public CajaDeAhorro(String nombreTitular, int maxExtracMensuales){
        super(nombreTitular); // ejecuta el constructor del padre sobre este mismo objeto
        this.maxExtracMensuales = maxExtracMensuales;
        this.cantExtracMensuales = 0;
    }

    @Override
    protected boolean puedeExtraer(float monto){
        if ((this.getSaldo() - monto > 0) && this.cantExtracMensuales < this.maxExtracMensuales)
            return true;
        return false;
    }
}
