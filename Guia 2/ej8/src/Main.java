import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        // 1. Crear listas de jugadores para River Plate
        ArrayList<Jugador> jugadoresRiver = new ArrayList<>();
        jugadoresRiver.add(new Jugador("Germán Burgos", Posiciones.ARQ.name()));
        jugadoresRiver.add(new Jugador("Celso Ayala", Posiciones.DEF.name()));
        jugadoresRiver.add(new Jugador("Leonardo Astrada", Posiciones.MC.name()));
        jugadoresRiver.add(new Jugador("Ariel Ortega", Posiciones.MC.name()));
        jugadoresRiver.add(new Jugador("Enzo Francescoli", Posiciones.DEL.name()));
        jugadoresRiver.add(new Jugador("Marcelo Salas", Posiciones.DEL.name()));

        // 2. Crear listas de jugadores para Boca Juniors
        ArrayList<Jugador> jugadoresBoca = new ArrayList<>();
        jugadoresBoca.add(new Jugador("Carlos Navarro Montoya", Posiciones.ARQ.name()));
        jugadoresBoca.add(new Jugador("Néstor Fabbri", Posiciones.DEF.name()));
        jugadoresBoca.add(new Jugador("Diego Cagna", Posiciones.MC.name()));
        jugadoresBoca.add(new Jugador("Juan Román Riquelme", Posiciones.MC.name()));
        jugadoresBoca.add(new Jugador("Diego Latorre", Posiciones.DEL.name()));
        jugadoresBoca.add(new Jugador("Hugo Guerra", Posiciones.DEL.name()));

        // 3. Crear listas de jugadores para Vélez Sarsfield
        ArrayList<Jugador> jugadoresVelez = new ArrayList<>();
        jugadoresVelez.add(new Jugador("José Luis Chilavert", Posiciones.ARQ.name()));
        jugadoresVelez.add(new Jugador("Mauricio Pellegrino", Posiciones.DEF.name()));
        jugadoresVelez.add(new Jugador("Guillermo Morigi", Posiciones.MC.name()));
        jugadoresVelez.add(new Jugador("Patricio Camps", Posiciones.DEL.name()));

        // 4. Crear listas de jugadores para Independiente
        ArrayList<Jugador> jugadoresIndependiente = new ArrayList<>();
        jugadoresIndependiente.add(new Jugador("Faryd Mondragón", Posiciones.ARQ.name()));
        jugadoresIndependiente.add(new Jugador("Pablo Rotchen", Posiciones.DEF.name()));
        jugadoresIndependiente.add(new Jugador("Roberto Acuña", Posiciones.MC.name()));
        jugadoresIndependiente.add(new Jugador("José Luis Calderón", Posiciones.DEL.name()));

        // 5. Crear Equipos usando el constructor Equipo(String, ArrayList<Jugador>)
        Equipo river = new Equipo("River Plate", jugadoresRiver);
        Equipo boca = new Equipo("Boca Juniors", jugadoresBoca);
        Equipo velez = new Equipo("Vélez Sarsfield", jugadoresVelez);
        Equipo independiente = new Equipo("Independiente", jugadoresIndependiente);

        // 6. Fechas del Torneo Apertura 1996
        Date fecha1 = new GregorianCalendar(1996, Calendar.AUGUST, 25).getTime();
        Date fecha2 = new GregorianCalendar(1996, Calendar.SEPTEMBER, 1).getTime();
        Date fecha3 = new GregorianCalendar(1996, Calendar.SEPTEMBER, 8).getTime();

        // 7. Crear Partidos
        Partido p1 = new Partido(river, boca, fecha1);
        Partido p2 = new Partido(velez, independiente, fecha1);
        Partido p3 = new Partido(river, velez, fecha2);
        Partido p4 = new Partido(boca, independiente, fecha2);
        Partido p5 = new Partido(independiente, river, fecha3);
        Partido p6 = new Partido(boca, velez, fecha3);

        p1.simularPartido();
        p2.simularPartido();
        p3.simularPartido();
        p4.simularPartido();
        p5.simularPartido();
        p6.simularPartido();

        IO.println("Jugadores de River: ");
        IO.println(river.getJugadores());

        IO.println("Jugadores de Boca: ");
        IO.println(boca.getJugadores());

        IO.println("Jugadores de Independiente: ");
        IO.println(independiente.getJugadores());

        IO.println("Jugadores de Velez: ");
        IO.println(velez.getJugadores());

    }
}