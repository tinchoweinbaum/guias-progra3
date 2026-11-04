import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorGoles {

    // Probabilidades especificadas (deben sumar 1.0 / 100%)
    private static final double[] PROBABILIDADES = {
            0.35, // 1 (35%)
            0.20, // 2 (20%)
            0.16, // 3 (16%)
            0.12, // 4 (12%)
            0.08, // 5 (8%)
            0.07, // 6 (7%)
            0.02  // 7 (2%)
    };

    private static final Random random = new Random();

    public static ArrayList<Jugador> getGoles(ArrayList<Jugador> jugadoresDisponibles) {
        ArrayList<Jugador> goleadores = new ArrayList<>();

        if (jugadoresDisponibles == null || jugadoresDisponibles.size() == 0) {
            return goleadores; // Devuelve una lista vacía de resguardo
        }

        // 1. Calcular la cantidad de goles
        double r = random.nextDouble(); // Genera un valor entre 0.0 y 1.0
        double acumulado = 0.0;
        int cantidadGoles = 7; // Resguardo por defecto

        for (int i = 0; i < PROBABILIDADES.length; i++) {
            acumulado += PROBABILIDADES[i];
            if (r < acumulado) {
                cantidadGoles = i + 1; // Retorna el número entre 1 y 7
                break;
            }
        }

        // 2. Asignar cada gol a un jugador y guardarlo en el ArrayList
        for (int i = 0; i < cantidadGoles; i++) {
            String posicionBuscada = obtenerPosicionGoleador();

            // Filtramos los jugadores que coinciden con la posición sorteada
            List<Jugador> candidatos = new ArrayList<>();
            for (Jugador j : jugadoresDisponibles) {
                if (j.getPosicion().toString().equals(posicionBuscada)) {
                    candidatos.add(j);
                }
            }

            // Resguardo: Si no hay jugadores de esa posición, usamos cualquiera de los disponibles
            if (candidatos.isEmpty()) {
                for (Jugador j : jugadoresDisponibles) {
                    candidatos.add(j);
                }
            }

            // Seleccionamos al azar y agregamos al ArrayList mediante .add()
            int indiceElegido = random.nextInt(candidatos.size());
            goleadores.add(candidatos.get(indiceElegido));
        }

        return goleadores;
    }

    // Método auxiliar para obtener la posición en base a los porcentajes dados
    private static String obtenerPosicionGoleador() {
        double r = random.nextDouble();
        if (r < 0.500) return "DEL";       // 50%
        if (r < 0.850) return "MC";        // 35% (50 + 35)
        if (r < 0.995) return "DEF";       // 14.5% (85 + 14.5)
        return "ARQ";                      // 0.5% (99.5 + 0.5)
    }
}