
import java.util.ArrayList;
import java.util.Date;

public class Partido {
    private Equipo eqA, eqB;
    private Date fecha;

    private int golesA;
    private int golesB;

    public Partido(Equipo eqA, Equipo eqB, Date fecha){
        this.eqA = eqA;
        this.eqB = eqB;
        this.fecha = fecha;
    }

    public void simularPartido(){
        if (this.eqA == null || this.eqB == null || this.fecha == null)
            return;

        ArrayList<Jugador> goleadoresA = GeneradorGoles.getGoles(eqA.getJugadores()); // Genera goles de cada equipo
        ArrayList<Jugador> goleadoresB = GeneradorGoles.getGoles(eqB.getJugadores());

        for (Jugador j: goleadoresA)
            j.sumarGol();
        for (Jugador jB: goleadoresB)
            jB.sumarGol();

        this.golesA = goleadoresA.size(); // Cantidad de goles de cada equipo
        this.golesB = goleadoresB.size();

        this.eqA.sumarGolesFavor(this.golesA);
        this.eqB.sumarGolesContra(this.golesA);

        this.eqA.sumarGolesContra(this.golesB);
        this.eqB.sumarGolesFavor(this.golesB);

        Equipo ganador, perdedor;
        if (this.golesA > this.golesB) {
            ganador = eqA;
            perdedor = eqB;
        }
        else if (this.golesB > this.golesA) {
            ganador = eqB;
            perdedor = eqA;
        }
        else {
            ganador = null;
            perdedor = null;
        }

        if (ganador != null) {
            ganador.sumarGanado();
            perdedor.sumarPerdido();
        }
        else {
            eqA.sumarEmpatado();
            eqB.sumarEmpatado();
        }

        eqA.sumarPartido(this); // Suma el objeto partido al arreglo de partidos del equipo
        eqB.sumarPartido(this);

        Liga.getInstancia().ordenarTabla();

        IO.println(eqA.getNombre() + " " + this.golesA + " - " + eqB.getNombre() + " " + this.golesB);

    }
}
