public class Main {
    public static void main(String[] args) {

        // 1. Instanciamos las cuentas usando polimorfismo (variable del tipo padre)
        CuentaBancaria caja = new CajaDeAhorro("Ana", 5);
        CuentaBancaria uni = new CuentaUniversitaria("Luis");
        CuentaBancaria corriente = new CuentaCorriente("Carlos", 5000f);

        // 2. Probamos los depósitos (todas comparten el mismo método del padre)
        System.out.println("--- DEPÓSITOS ---");
        caja.hacerDeposito(10000f);
        uni.hacerDeposito(5000f);
        corriente.hacerDeposito(2000f);

        System.out.println(caja.getNombreTitular() + " saldo: $" + caja.getSaldo());
        System.out.println(uni.getNombreTitular() + " saldo: $" + uni.getSaldo());
        System.out.println(corriente.getNombreTitular() + " saldo: $" + corriente.getSaldo());

        // 3. Probamos las extracciones (se ejecuta el puedeExtraer() de cada hija)
        System.out.println("\n--- EXTRACCIONES ---");

        boolean exCaja = caja.hacerExtraccion(2000f);
        System.out.println("Ana pudo extraer $2000? " + exCaja + " | Saldo: $" + caja.getSaldo());

        boolean exUni = uni.hacerExtraccion(800f);
        System.out.println("Luis pudo extraer $800? " + exUni + " | Saldo: $" + uni.getSaldo());

        boolean exCorriente = corriente.hacerExtraccion(3000f);
        System.out.println("Carlos pudo extraer $3000? " + exCorriente + " | Saldo: $" + corriente.getSaldo());


        // 4. Uso de métodos específicos de las clases hijas mediante CASTEO
        System.out.println("\n--- MÉTODOS ESPECÍFICOS (CASTEO) ---");

        // Casteamos 'uni' a 'CuentaUniversitaria' para acceder a su método particular
        ((CuentaUniversitaria) uni).resetearExtraidoHoy();
        System.out.println("Se reseteó el límite diario de la cuenta de Luis.");

        // Casteamos 'corriente' a 'CuentaCorriente' para cambiar su tope
        ((CuentaCorriente) corriente).cambiarTopeDescubierto(10000f);
        System.out.println("Se actualizó el tope de descubierto de la cuenta de Carlos a $10000.");
    }
}