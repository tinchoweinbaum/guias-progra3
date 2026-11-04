package vehiculos;

public class Camion extends Vehiculo{
    private float cargaMax;
    private float tara;
    Acoplado acoplado;

    public Camion(String patente, String modelo, float cargaMax, float tara, Acoplado acoplado) {
        super(patente, modelo);
        this.cargaMax = cargaMax;
        this.tara = tara;
        this.acoplado = acoplado;
    }
}
