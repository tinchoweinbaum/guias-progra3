import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private int cantGanados;
    private int cantEmpatados;
    private int cantPerdidos;
    private int golesFavor;
    private int golesContra;

    private ArrayList<Jugador> jugadores;
    private ArrayList<Partido> partidos;

    int puntos;

    public Equipo(String nombre, ArrayList<Jugador> jugadores){
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.partidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantGanados() {
        return cantGanados;
    }


    public int getCantEmpatados() {
        return cantEmpatados;
    }

    public int getCantPerdidos() {
        return cantPerdidos;
    }

    public void sumarGanado(){
        this.cantGanados++;
    }

    public void sumarEmpatado(){
        this.cantEmpatados++;
    }

    public void sumarPerdido(){
        this.cantPerdidos++;
    }

    public void sumarGolesFavor(int goles){
        this.golesFavor += goles;
    }

    public void sumarGolesContra(int goles){
        this.golesContra += goles;
    }

    public void agregarPartidoJugado(Partido p){
        this.partidos.add(p);
    }

    public void agregarJugador(Jugador j){
        this.jugadores.add(j);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void sumarPartido(Partido p){
        this.partidos.add(p);
    }

    public int getPuntos(){
        return this.puntos;
    }
}
