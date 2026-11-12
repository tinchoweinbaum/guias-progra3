import java.io.Serializable;

public abstract class Vehiculo implements Serializable {
    private String nChasis;
    private int anioFabricacion;

    public Vehiculo() {
    }

    public Vehiculo(String nChasis, int anioFabricacion) {
        this.nChasis = nChasis;
        this.anioFabricacion = anioFabricacion;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getNChasis() {
        return nChasis;
    }

    public void setNChasis(String nChasis) {
        this.nChasis = nChasis;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "nChasis='" + nChasis + '\'' +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }
}
