import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Mazo {
    private ArrayList<Carta> cartas;
    private int turnoAct = 1;
    private ArrayList<Jugador> jugadores;
    private int cantJugadores;
    public static boolean juegoTerminado = false;

    public Mazo(ArrayList<Carta> cartas, ArrayList<Jugador> jugadores, int cantJugadores) {
        this.cartas = cartas;
        this.jugadores = jugadores;
        this.cantJugadores = cantJugadores;
    }

    public synchronized boolean pedirCarta(Jugador j){
        while(this.turnoAct != j.getTurno() && !juegoTerminado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupción en pedirCarta");
            }
        }
        if(this.juegoTerminado)
            return false;

        if (!cartas.isEmpty()){
            int nroCarta = ThreadLocalRandom.current().nextInt(cartas.size());
            Carta cartaElegida = cartas.get(nroCarta);
            j.recibirCarta(cartaElegida); // Sumo la carta al array list del jugador y la elimino del mazo
            cartas.remove(nroCarta);
            System.out.println(j + " sacó un " + cartaElegida.getValor());
            return true;
        }
        else{ // No hay más cartas, fin del juego.
            this.juegoTerminado = true;
            notifyAll();
            return false;
        }
    }

    private Jugador buscaGanadorMano(){
        if (jugadores == null || jugadores.isEmpty()) {
            return null;
        }

        Jugador mejorJugador = null;
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntajeTotal() <= 21) {
                if (mejorJugador == null || jugador.compareTo(mejorJugador) > 0) {
                    mejorJugador = jugador;
                }
            }
        }
        return mejorJugador; // Retorna el mejor o null si ninguno calificó
    }

    public synchronized void liberar(Jugador j){
        // Si alguien vació el mazo, la ronda se anula y no evaluamos a los ganadores
        if (juegoTerminado) {
            notifyAll();
            return;
        }

        this.turnoAct++;
        if(this.turnoAct > cantJugadores){
            Jugador ganador = this.buscaGanadorMano();
            if (ganador != null) {
                ganador.ganaMano();
                System.out.println(ganador + " ganó esta mano\n");
            }
            else{
                System.out.println("Nadie ganó esta mano.\n");
            }

            // EL CROUPIER LIMPIA LAS CARTAS PARA LA SIGUIENTE RONDA
            for (Jugador jugador : jugadores) {
                jugador.limpiarCartas();
            }

            this.turnoAct = 1;
        }
        notifyAll();
    }
}
