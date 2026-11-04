// La clase hija de esta clase cuentaUniversitaria necesita un parametro extra en el metodo
// para extraer, me conviene hacer un metodo nuevo en esa clase? Puedo hacer que todas las
// extracciones reciban un objeto Operacion?
// Si reciben tdas un objeto de tipo operacion podria usar siempre variables de tipo padre
// tendria que agregar tambien un arrayList de movimientos en las cuentas

public abstract class CuentaBancaria {
    private final String nombreTitular;
    private float saldo = 0;


    public CuentaBancaria(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNombreTitular(){
        return this.nombreTitular;
    }

    public float getSaldo(){
        return this.saldo;
    }

    public void hacerDeposito(float cantidad){
        if (cantidad > 0)
            this.saldo += cantidad;
    }

    public boolean hacerExtraccion(float cantidad){
        if (cantidad > 0 && this.puedeExtraer(cantidad)){
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    abstract boolean puedeExtraer(float monto);
}
