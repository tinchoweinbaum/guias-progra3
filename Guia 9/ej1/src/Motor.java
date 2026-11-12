import java.io.Serializable;

public class Motor implements Serializable {
    private String nSerie;
    private String combustible;

    public Motor() {
    }

    public Motor(String nSerie, String combustible) {
        this.nSerie = nSerie;
        this.combustible = combustible;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}
