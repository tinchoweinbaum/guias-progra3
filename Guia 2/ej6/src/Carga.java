public class Carga {
    private String tipoCombustible;
    private  int litros;

    public Carga(String tipoCombustible, int litros) {
        this.tipoCombustible = tipoCombustible;
        this.litros = litros;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public int getLitros() {
        return litros;
    }
}