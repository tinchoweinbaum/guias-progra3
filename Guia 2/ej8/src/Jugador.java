enum Posiciones { DEL, MC, DEF, ARQ }

public class Jugador {
    private String nombre;
    private String posicion;

    private int cantGoles;

    public Jugador(String nombre, String posicion){
        this.nombre = nombre;
        this.posicion = posicion;
        this.cantGoles = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void sumarGol(){
        this.cantGoles++;
    }

    @Override
    public String toString() {
        return nombre + " (" + posicion + ") - Goles: " + cantGoles;
    }
}
