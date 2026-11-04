package choferes;

public class Categoria {
    String nombreCategoria;
    double sueldo;
    boolean habilitaColectivoLinea;
    boolean habilitaColectivoLarga;
    boolean habilitaCamion;

    public Categoria(String nombreCategoria, double sueldo, boolean habilitaColectivoLinea, boolean habilitaColectivoLarga, boolean habilitaCamion) {
        this.nombreCategoria = nombreCategoria;
        this.sueldo = sueldo;
        this.habilitaColectivoLinea = habilitaColectivoLinea;
        this.habilitaColectivoLarga = habilitaColectivoLarga;
        this.habilitaCamion = habilitaCamion;
    }
}
