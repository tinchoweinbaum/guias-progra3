import java.util.ArrayList;

public class Jugador implements Runnable, Comparable<Jugador>{
    ArrayList<Carta> cartas = new ArrayList<>();

    private String nombre;
    private int turno;
    private int manosGanadas = 0;
    private Mazo mazo;
    private boolean plantado;

    public Jugador(String nombre, int turno) {
        this.nombre = nombre;
        this.turno = turno;
    }

    @Override
    public void run() {
        while (true) {
            boolean hayCartas = true;

            // Pido cartas mientras tenga 15 o menos
            while (this.getPuntajeTotal() <= 15) {
                hayCartas = this.mazo.pedirCarta(this);
                // Si el mazo avisa que no hay más cartas, rompo este bucle
                if (!hayCartas) {
                    break;
                }
            }

            // Si salí del bucle porque se acabó el mazo, rompo el while(true) y el hilo muere
            if (!hayCartas) {
                break;
            }

            if (this.getPuntajeTotal() <= 21) {
                this.plantado = true;
            } else {
                System.out.println(this + " se pasó de 21.");
                this.plantado = false;
            }

            this.mazo.liberar(this);
        }
    }

    // Agrega este método a la clase Jugador
    public void limpiarCartas() {
        this.cartas.clear();
        this.plantado = false;
    }

    @Override
    public int compareTo(Jugador otro) {
        return Integer.compare(this.getPuntajeTotal(), otro.getPuntajeTotal());
    }

    public int getPuntajeTotal(){
        if (cartas.isEmpty())
            return 0;

        int total = 0;
        for (Carta c: this.cartas)
            total += c.getValor();
        return total;
    }

    public int getTurno() {
        return turno;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public void recibirCarta(Carta c){
        this.cartas.add(c);
    }

    public boolean esManoPerdida(){
        return !this.plantado;
    }

    public void ganaMano(){
        this.manosGanadas++;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getManosGanadas() {
        return manosGanadas;
    }

    public static Jugador obtenerGanador(ArrayList<Jugador> jugadores) {
        if (jugadores == null || jugadores.isEmpty()) {
            return null;
        }

        Jugador ganador = jugadores.get(0);

        for (Jugador j : jugadores) {
            if (j.getManosGanadas() > ganador.getManosGanadas()) {
                ganador = j;
            }
        }

        return ganador;
    }
}
