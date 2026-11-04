public class CuentaCorriente extends CuentaBancaria {
    private float topeDescubierto;

    public CuentaCorriente(String nombreTitular, float topeDescubierto) {
        super(nombreTitular);
        this.topeDescubierto = topeDescubierto;
    }

    @Override
    protected boolean puedeExtraer(float monto) {
        if ((this.getSaldo() - monto) < this.topeDescubierto)
            return true;
        return false;
    }

    // Es la idea tener que castear para llamar a este metodo? o hay un metodo abstracto que no estoy pudiendo ver en CuentaBancaria?
    public void cambiarTopeDescubierto(float limiteNuevo){
        this.topeDescubierto = limiteNuevo;
    }
}
