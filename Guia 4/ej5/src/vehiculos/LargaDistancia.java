package vehiculos;

public class LargaDistancia extends Colectivo{
    boolean cocheCama;

    public LargaDistancia(String patente, String modelo, int cantidadPasajeros, boolean cocheCama) {
        super(patente, modelo, cantidadPasajeros);
        this.cocheCama = cocheCama;
    }

    public void setCocheCama(boolean cocheCama) {
        this.cocheCama = cocheCama;
    }
}
