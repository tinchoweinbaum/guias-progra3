public class CuentaUniversitaria extends CuentaBancaria{
    final private float  topeExtraccion = 1000;
    private float extraidoHoy;

    public CuentaUniversitaria(String nombreTitular){
        super(nombreTitular);
        this.extraidoHoy = 0;
    }

    // No discrimina entre YA pasado del limite y "me voy a pasar del limite con esta extraccion"
    @Override
    protected boolean puedeExtraer(float monto){
        if ((this.getSaldo() - monto) > 0 && (this.extraidoHoy + monto) < this.topeExtraccion)
            return true;
        return false;
    }

    // Esta funcion no puede llamarse desde una variable de tipo padre, hay que castear.
    public void resetearExtraidoHoy(){
        this.extraidoHoy = 0;
    }
}
